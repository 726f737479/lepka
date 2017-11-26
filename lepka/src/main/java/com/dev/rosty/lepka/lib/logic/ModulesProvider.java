package com.dev.rosty.lepka.lib.logic;

import android.app.Activity;

import com.dev.rosty.lepka.lib.Module;
import com.dev.rosty.lepka.lib.Screen;
import com.dev.rosty.lepka.lib.router.Priority;

import java.util.List;

/**
 * Created by rosty on 11/23/17.
 */

class ModulesProvider {

    private List<Module> appModules;

    ModulesProvider(List<Module> appModules) {
        this.appModules = appModules;
    }

    Module findControllerForScreen(Screen screen) {

        @Priority int priority = Priority.LOW;

        Module bestModule = null;

        for (Module module : appModules) {

            if (module.canOpen(screen)) {

                int tempPriority = module.getPriority(screen);

                if (tempPriority < priority)
                    bestModule = module;
            }
        }

        if (bestModule != null) return bestModule;

        throw new RuntimeException("You have no controllers that can open " + screen.getClass().getName());
    }

    Module findControllerByActivity(Activity activity) {
        return findControllerByActivity(activity.getClass());
    }

    private Module findControllerByActivity(Class activityClass) {

        for (Module module : appModules) {

            if (module.getActivityClass().equals(activityClass))
                return module;
        }

        throw new RuntimeException("You have no controllers for " + activityClass.getSimpleName());
    }
}
