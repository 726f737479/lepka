package com.dev.rosty.lepka.lib.logic.backstack;

import android.app.Activity;


public interface BackStack {

    void setup(Activity activity);
    void registerForChanges(Observer observer);
    void unregisterForChanges();

    int count();
    boolean isEmpty();

    interface Observer { void onChanged(int count); }
}
