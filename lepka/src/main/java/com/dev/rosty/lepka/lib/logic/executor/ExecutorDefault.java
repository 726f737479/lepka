package com.dev.rosty.lepka.lib.logic.executor;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.dev.rosty.lepka.lib.Module;
import com.dev.rosty.lepka.lib.Screen;
import com.dev.rosty.lepka.lib.util.KeysUtil;

import java.lang.ref.WeakReference;

/**
 * Created by rosty on 11/25/17.
 */

public final class ExecutorDefault implements Executor {

    private WeakReference<FragmentManager> fragmentManager = new WeakReference<>(null);
    private WeakReference<Activity>        activity        = new WeakReference<>(null);

    @Override public void setup(Activity activity) {

        this.activity        = new WeakReference<>(activity);
        this.fragmentManager = new WeakReference<>(activity.getFragmentManager());
    }

    @Override public void openScreen(Module module, Screen screen, String key) {

        FragmentTransaction transaction = fragmentManager.get().beginTransaction();

        Fragment fragment  = buildFragment(screen.getFragmentClass());
        Bundle   arguments = new Bundle();

        arguments.putString(KeysUtil.EXTRA_SCREEN_KEY, key);
        fragment.setArguments(arguments);

        transaction.replace(module.provideContainer(), fragment);
        transaction.addToBackStack(screen.getFragmentClass().getSimpleName());
        transaction.commit();
    }

    @Override public void openRouter(Module module, String key) {

        Intent intent = new Intent(activity.get(), module.getActivityClass());
        intent.putExtra(KeysUtil.EXTRA_MODULE_KEY, key);

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
}
