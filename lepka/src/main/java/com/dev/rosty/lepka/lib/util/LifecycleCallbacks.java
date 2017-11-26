package com.dev.rosty.lepka.lib.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by rosty on 11/23/17.
 */

public abstract class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    private static final String TAG = LifecycleCallbacks.class.getSimpleName();

    @Override public void onActivityCreated(Activity activity, Bundle bundle) {
        Log.d(TAG, activity.getClass().getSimpleName() + " created");
    }

    @Override public void onActivityStarted(Activity activity) {
        Log.d(TAG, activity.getClass().getSimpleName() + " started");
    }

    @Override public void onActivityResumed(Activity activity) {
        Log.d(TAG, activity.getClass().getSimpleName() + " resumed");
    }

    @Override public void onActivityPaused(Activity activity) {
        Log.d(TAG, activity.getClass().getSimpleName() + " paused");
    }

    @Override public void onActivityStopped(Activity activity) {
        Log.d(TAG, activity.getClass().getSimpleName() + " stopped");
    }

    @Override public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Log.d(TAG, activity.getClass().getSimpleName() + " save state");
    }

    @Override public void onActivityDestroyed(Activity activity) {
        Log.d(TAG, activity.getClass().getSimpleName() + " destroyed");
    }
}
