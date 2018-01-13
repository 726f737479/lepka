package com.dev.rosty.lepka.lib.logic.executor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.dev.rosty.lepka.lib.Module;
import com.dev.rosty.lepka.lib.Screen;
import com.dev.rosty.lepka.lib.transition.TransactionManagerSupport;
import com.dev.rosty.lepka.lib.util.KeysUtil;

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

    @Override public void openScreen(Module module, Screen screen, String key, boolean clear) {

        if (clear) popBackStack();

        Fragment fragment = buildFragment(screen.getFragmentClass());
        Bundle arguments = new Bundle();

        FragmentTransaction transaction = fragmentManager.get().beginTransaction();

        arguments.putString(KeysUtil.EXTRA_SCREEN_KEY, key);
        fragment.setArguments(arguments);

        transaction.replace(module.provideContainer(), fragment);
        transaction.addToBackStack(screen.getFragmentClass().getSimpleName());

        if (activity instanceof TransactionManagerSupport)
            ((TransactionManagerSupport) activity).manage(transaction);

        transaction.commit();
    }

    @Override public void openRouter(Module module, String key, boolean clear) {

        Intent intent = new Intent(activity.get(), module.getActivityClass());
        intent.putExtra(KeysUtil.EXTRA_MODULE_KEY, key);

        if (clear) intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        activity.get().startActivity(intent);
    }

    @Override public void closeScreen() {
        fragmentManager.get().popBackStack();
    }

    @Override public void closeRouter() {
        activity.get().finish();
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
