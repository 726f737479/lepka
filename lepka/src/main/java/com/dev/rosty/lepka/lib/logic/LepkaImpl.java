package com.dev.rosty.lepka.lib.logic;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.VisibleForTesting;

import com.dev.rosty.lepka.lib.Command;
import com.dev.rosty.lepka.lib.Lepka;
import com.dev.rosty.lepka.lib.Module;
import com.dev.rosty.lepka.lib.Screen;
import com.dev.rosty.lepka.lib.command.Back;
import com.dev.rosty.lepka.lib.command.BackTo;
import com.dev.rosty.lepka.lib.command.Forward;
import com.dev.rosty.lepka.lib.command.ForwardClear;
import com.dev.rosty.lepka.lib.logic.backstack.BackStack;
import com.dev.rosty.lepka.lib.logic.executor.Executor;
import com.dev.rosty.lepka.lib.screen.Data;
import com.dev.rosty.lepka.lib.util.KeysUtil;
import com.dev.rosty.lepka.lib.util.LifecycleCallbacks;


public final class LepkaImpl implements Lepka {

    @VisibleForTesting final Executor executor;
    @VisibleForTesting final BackStack backStack;
    @VisibleForTesting final ModulesPool modulesPool;
    @VisibleForTesting final DataHeap dataHeap;

    @VisibleForTesting Module module;
    @VisibleForTesting Screen screen;
    @VisibleForTesting Screen entry;

    private String moduleKey;

    LepkaImpl(Application application,
              Screen entry,
              Executor executor,
              ModulesPool modulesPool,
              BackStack backStack,
              DataHeap dataHeap) {

        this.executor = executor;
        this.backStack = backStack;
        this.modulesPool = modulesPool;
        this.entry = entry;
        this.dataHeap = dataHeap;
        this.module = modulesPool.findControllerForScreen(entry);

        application.registerActivityLifecycleCallbacks(new LifecycleObserver());
    }

    @Override public void execute(Command command) {

        if (command instanceof Forward) forwardCommand(((Forward) command).screen, false);

        if (command instanceof Back) backCommand();

        if (command instanceof ForwardClear) forwardCommand(((ForwardClear) command).screen, true);

        if (command instanceof BackTo) backToCommand(((BackTo) command).screen);
    }

    @Override public Data produceScreenData(String screenKey) {

        return dataHeap.getData(moduleKey, screenKey);
    }

    private void forwardCommand(Screen screen, boolean clear) {

        this.screen = screen;

        if (clear) backStack.unregisterForChanges();

        if (!module.canOpen(screen)) {

            module = modulesPool.findControllerForScreen(screen);
            String moduleKey = KeysUtil.generateModuleKey(module);

            executor.openRouter(module, moduleKey, clear);

        } else {

            String screenKey = KeysUtil.generateScreenKey(screen);

            executor.openScreen(module, screen, screenKey, clear);
            dataHeap.addData(moduleKey, screenKey, screen.getData());
        }

        if (clear) backStack.registerForChanges(new BackStackObserver());
    }

    private void backCommand() {

        if (backStack.count() > 1)
            executor.closeScreen();

        else executor.closeRouter();
    }

    private void backToCommand(Screen screen) {

    }

    private final class LifecycleObserver extends LifecycleCallbacks {

        @Override public void onActivityResumed(final Activity activity) {
            super.onActivityResumed(activity);

            module = modulesPool.findControllerByActivity(activity);
            moduleKey = KeysUtil.getModuleKey(activity);

            executor.setup(activity);
            backStack.setup(activity);
            backStack.registerForChanges(new BackStackObserver());

            if (backStack.isEmpty()) forwardCommand(screen == null ? entry : screen, false);
        }

        @Override public void onActivityPaused(Activity activity) {
            super.onActivityPaused(activity);

            if (activity.isFinishing()) {

                if (backStack.isEmpty()) screen = null;

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
