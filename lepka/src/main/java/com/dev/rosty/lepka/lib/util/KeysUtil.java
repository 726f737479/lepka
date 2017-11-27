package com.dev.rosty.lepka.lib.util;

import android.app.Activity;
import android.os.Bundle;

import com.dev.rosty.lepka.lib.Module;
import com.dev.rosty.lepka.lib.Screen;

/**
 * Class that helps generate and retrieve keys for {@link Screen} and {@link Module}
 */
public class KeysUtil {

    public static final String EXTRA_SCREEN_KEY = "screen_key";
    public static final String EXTRA_MODULE_KEY = "module_key";
    public static final String EXTRA_VIEW_KEY   = "view_key";

    /**
     * Retrieve a key for {@link Module}
     *
     * @param activity that associated with {@link Module}
     * @return key for {@link Module}
     */
    public static String getModuleKey(Activity activity) {

        if (activity.getIntent().getExtras() == null)
            return getLaunchModuleKey(activity);

        return activity.getIntent().getExtras().getString(EXTRA_MODULE_KEY);
    }

    /**
     * Retrieve a key for {@link Screen}
     *
     * @param arguments from {@link android.app.Fragment} or {@link android.support.v4.app.Fragment}
     *                  that associated with {@link Screen}
     *
     * @return key for {@link Screen}
     */
    public static String getScreenKey(Bundle arguments) {

        return arguments.getString(EXTRA_SCREEN_KEY);
    }

    /**
     * Retrieve a key for shared element {@link android.view.View}
     *
     * @param arguments from {@link android.app.Fragment} or {@link android.support.v4.app.Fragment}
     *                  that associated with {@link Screen}
     *
     * @return key for {@link android.view.View}
     */
    public static String getViewKey(Bundle arguments) {

        return arguments.getString(EXTRA_VIEW_KEY);
    }

    /**
     * Generate key for {@link Module}
     *
     * @param module to which you need to generate key
     * @return key for specified {@link Module}
     */
    public static String generateModuleKey(Module module) {

        return module.getClass().getSimpleName().concat(String.valueOf(System.currentTimeMillis()));
    }

    /**
     * Generate key for {@link Screen}
     *
     * @param screen to which you need to generate key
     * @return key for specified {@link Screen}
     */
    public static String generateScreenKey(Screen screen) {

        return screen.getClass().getSimpleName().concat(String.valueOf(System.currentTimeMillis()));
    }

    private static String getLaunchModuleKey(Activity activity) {

        return activity.getClass().getSimpleName()
                .replace("Activity", "")
                .concat("ModuleLaunch");
    }
}
