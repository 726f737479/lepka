package com.dev.rosty.lepka.lib.logic.backstack;

import android.app.Activity;

/**
 * Created by rosty on 11/24/17.
 */

public interface BackStack {

    void setup(Activity activity);
    void registerForChanges(Observer observer);
    void unregisterForChanges();

    int count();
    boolean isEmpty();

    interface Observer { void onChanged(int count); }
}
