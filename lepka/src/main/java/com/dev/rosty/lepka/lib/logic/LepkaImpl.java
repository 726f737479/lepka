package com.dev.rosty.lepka.lib.logic;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.VisibleForTesting;

import com.dev.rosty.lepka.lib.Command;
import com.dev.rosty.lepka.lib.Module;
import com.dev.rosty.lepka.lib.Lepka;
import com.dev.rosty.lepka.lib.Screen;
import com.dev.rosty.lepka.lib.command.BackTo;
import com.dev.rosty.lepka.lib.command.ForwardPop;
import com.dev.rosty.lepka.lib.logic.backstack.BackStack;
import com.dev.rosty.lepka.lib.logic.executor.Executor;
import com.dev.rosty.lepka.lib.screen.Data;
import com.dev.rosty.lepka.lib.command.Back;
import com.dev.rosty.lepka.lib.command.Forward;
import com.dev.rosty.lepka.lib.util.KeysUtil;
import com.dev.rosty.lepka.lib.util.LifecycleCallbacks;

/**
 * Created by rosty on 11/12/17.
 */

public final class LepkaImpl implements Lepka {

    @VisibleForTesting final Executor        executor;
    @VisibleForTesting final BackStack       backStack;
    @VisibleForTesting final ModulesProvider modulesProvider;
    @VisibleForTesting final DataHeap        dataHeap;

    @VisibleForTesting  Module module;
    @VisibleForTesting  Screen screen;
    @VisibleForTesting  Screen entry;

    private String moduleKey;

    LepkaImpl(Application     application,
              Screen          entry,
              Executor        executor,
              ModulesProvider modulesProvider,
              BackStack       backStack,
              DataHeap        dataHeap) {

        this.executor        = executor;
        this.backStack       = backStack;
        this.modulesProvider = modulesProvider;
        this.entry           = entry;
        this.dataHeap        = dataHeap;
        this.module          = modulesProvider.findControllerForScreen(entry);

        application.registerActivityLifecycleCallbacks(new LifecycleObserver());
    }

    @Override public void execute(Command command) {

        if (command instanceof Forward) forwardCommand(((Forward) command).getScreen());

        if (command instanceof Back) backCommand();

        if (command instanceof ForwardPop) forwardPopCommand(((ForwardPop) command).getScreen());

        if (command instanceof BackTo) backToCommand(((BackTo) command).getScreen());
    }

    @Override public Data produceScreenData(String screenKey) {

        return dataHeap.getData(moduleKey, screenKey);
    }

    private void forwardCommand(Screen screen) {

        this.screen = screen;

        if (!module.canOpen(screen)) {

            String moduleKey = KeysUtil.generateModuleKey(module);

            module = modulesProvider.findControllerForScreen(screen);
            executor.openRouter(module, moduleKey);

        } else {

            String screenKey = KeysUtil.generateScreenKey(screen);

            executor.openScreen(module, screen, screenKey);
            dataHeap.addData(moduleKey, screenKey, screen.getData());
        }
    }

    private void backCommand() {

        if (backStack.count() > 1)
            executor.closeScreen();

        else executor.closeRouter();
    }

    private void backToCommand(Screen screen) {

    }

    private void forwardPopCommand(Screen screen) {

    }

    private final class LifecycleObserver extends LifecycleCallbacks {

        @Override public void onActivityResumed(final Activity activity) {
            super.onActivityResumed(activity);

            module    = modulesProvider.findControllerByActivity(activity);
            moduleKey = KeysUtil.getModuleKey(activity);

            executor.setup(activity);
            backStack.setup(activity);
            backStack.registerForChanges(new BackStackObserver());

            if (backStack.isEmpty()) forwardCommand(screen == null ? entry : screen);
        }

        @Override public void onActivityPaused(Activity activity) {
            super.onActivityPaused(activity);

            if (activity.isFinishing()) {

                screen = null;
                backStack.unregisterForChanges();
                dataHeap.clearData(KeysUtil.getModuleKey(activity));
            }
        }
    }

    private final class BackStackObserver implements BackStack.Observer {

        @Override public void onChanged(int count) {

            if (count == 0) backCommand();
        }
    }
}
