package com.dev.rosty.lepka.lib.util;

import android.app.Activity;
import android.os.Bundle;

import com.dev.rosty.lepka.lib.Module;
import com.dev.rosty.lepka.lib.Screen;

/**
 * Created by rosty on 11/25/17.
 */

public class KeysUtil {

    public static final String EXTRA_SCREEN_KEY  = "screen_key";
    public static final String EXTRA_MODULE_KEY = "module_key";

    public static String getModuleKey(Activity activity) {

        if (activity.getIntent().getExtras() == null)
            return getLaunchModuleKey(activity);

        return activity.getIntent().getExtras().getString(EXTRA_MODULE_KEY);
    }

    public static String getScreenKey(Bundle arguments) {

        return arguments.getString(EXTRA_SCREEN_KEY);
    }

    public static String generateModuleKey(Module module) {

        return module.getClass().getSimpleName().concat(String.valueOf(System.currentTimeMillis()));
    }

    public static String generateScreenKey(Screen screen) {

        return screen.getClass().getSimpleName().concat(String.valueOf(System.currentTimeMillis()));
    }

    private static String getLaunchModuleKey(Activity activity) {

        return activity.getClass().getSimpleName()
                .replace("Activity", "")
                .concat("ModuleLaunch");
    }
}
