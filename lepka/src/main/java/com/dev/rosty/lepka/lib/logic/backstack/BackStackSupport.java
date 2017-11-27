package com.dev.rosty.lepka.lib.logic.backstack;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;


public final class BackStackSupport implements BackStack {

    private WeakReference<FragmentManager> fragmentManager = new WeakReference<>(null);

    private Observer observer;

    @Override public void setup(Activity activity) {
        this.fragmentManager = new WeakReference<>(
                ((AppCompatActivity) activity).getSupportFragmentManager());
    }

    @Override public void registerForChanges(Observer observer) {

        this.observer = observer;
        fragmentManager.get().addOnBackStackChangedListener(backStackObserver);
    }

    @Override public void unregisterForChanges() {

        this.observer = null;
        fragmentManager.get().removeOnBackStackChangedListener(backStackObserver);
    }

    @Override public int count() {
        return fragmentManager.get() == null ? 0 : fragmentManager.get().getBackStackEntryCount();
    }

    @Override public boolean isEmpty() {
        return count() == 0;
    }

    private final OnBackStackChangedListener backStackObserver = new OnBackStackChangedListener() {

        @Override public void onBackStackChanged() {

            if (observer != null) observer.onChanged(count());
        }
    };
}
