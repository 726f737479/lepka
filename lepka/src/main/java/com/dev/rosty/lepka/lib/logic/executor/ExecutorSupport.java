package com.dev.rosty.lepka.lib.logic.executor;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.dev.rosty.lepka.lib.Module;
import com.dev.rosty.lepka.lib.Screen;
import com.dev.rosty.lepka.lib.transition.TransactionManagerSupport;

import java.lang.ref.WeakReference;


public final class ExecutorSupport implements Executor {

    private WeakReference<FragmentManager> fragmentManager = new WeakReference<>(null);
    private WeakReference<Activity> activity = new WeakReference<>(null);

    @Override public void setup(Activity activity) {

        FragmentManager fragmentManager = ((AppCompatActivity) activity)
                .getSupportFragmentManager();

        this.activity = new WeakReference<>(activity);
        this.fragmentManager = new WeakReference<>(fragmentManager);
    }

    @Override public void openScreen(Module module, Screen screen, boolean clear) {

        if (clear) popBackStack();

        Fragment fragment = buildFragment(screen.getFragmentClass());
        fragment.setArguments(screen.getData());

        FragmentTransaction transaction = fragmentManager.get().beginTransaction();
        transaction.replace(module.provideContainer(), fragment);
        transaction.addToBackStack(screen.getFragmentClass().getSimpleName());

        if (activity instanceof TransactionManagerSupport)
            ((TransactionManagerSupport) activity).manage(transaction);

        transaction.commit();
    }

    @Override public void openRouter(Module module, boolean clear) {

        Intent intent = new Intent(activity.get(), module.getActivityClass());

        if (clear) intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        activity.get().startActivity(intent);
    }

    @Override public void closeScreen() {
        fragmentManager.get().popBackStack();
    }

    @Override public void closeRouter() {
        activity.get().finish();
    }

    @Override public boolean popScreensTo(Screen screen) {

        int count = fragmentManager.get().getBackStackEntryCount();

        for (int i = count; i > 0; i--) {

            String name = fragmentManager.get().getBackStackEntryAt(i - 1).getName();

            if (name.equals(screen.getFragmentClass().getSimpleName()))
                return true;

            fragmentManager.get().popBackStack();
        }

        return false;
    }

    private Fragment buildFragment(Class fragmentClass) {
        return Fragment.instantiate(activity.get(), fragmentClass.getName());
    }

    private void popBackStack() {

        int count = fragmentManager.get().getBackStackEntryCount();

        for (int i = 0; i < count; i++)
            fragmentManager.get().popBackStack();
    }
}
