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
import com.dev.rosty.lepka.lib.util.LifecycleCallbacks;


public final class LepkaImpl implements Lepka {

    @VisibleForTesting final Executor executor;
    @VisibleForTesting final BackStack backStack;
    @VisibleForTesting final ModulesPool modulesPool;

    @VisibleForTesting Module module;
    @VisibleForTesting Screen forward;
    @VisibleForTesting Screen entry;
    @VisibleForTesting Screen backTo;

    LepkaImpl(Application application,
              Screen entry,
              Executor executor,
              ModulesPool modulesPool,
              BackStack backStack) {

        this.executor = executor;
        this.backStack = backStack;
        this.modulesPool = modulesPool;
        this.entry = entry;
        this.module = modulesPool.findControllerForScreen(entry);

        application.registerActivityLifecycleCallbacks(new LifecycleObserver());
    }

    @Override public void execute(Command command) {

        if (command instanceof Forward) forwardCommand(((Forward) command).screen, false);

        if (command instanceof Back) backCommand();

        if (command instanceof ForwardClear) forwardCommand(((ForwardClear) command).screen, true);

        if (command instanceof BackTo) backToCommand(((BackTo) command).screen);
    }

    private void forwardCommand(Screen screen, boolean clear) {

        this.forward = screen;

        if (clear) backStack.unregisterForChanges();

        if (!module.canOpen(screen)) {

            module = modulesPool.findControllerForScreen(screen);

            executor.openRouter(module, clear);

        } else executor.openScreen(module, screen, clear);

        if (clear) backStack.registerForChanges(new BackStackObserver());
    }

    private void backCommand() {

        if (backStack.count() > 1)
            executor.closeScreen();

        else executor.closeRouter();
    }

    private void backToCommand(Screen screen) {

        backTo = executor.popScreensTo(screen) ? null : screen;
    }

    private final class LifecycleObserver extends LifecycleCallbacks {

        @Override public void onActivityResumed(final Activity activity) {
            super.onActivityResumed(activity);

            module = modulesPool.findControllerByActivity(activity);

            executor.setup(activity);
            backStack.setup(activity);
            backStack.registerForChanges(new BackStackObserver());

            if (backStack.isEmpty()) forwardCommand(forward == null ? entry : forward, false);
            else if (backTo != null) backToCommand(backTo);
        }

        @Override public void onActivityPaused(Activity activity) {
            super.onActivityPaused(activity);

            if (activity.isFinishing()) {

                if (backStack.isEmpty()) forward = null;

                backStack.unregisterForChanges();
            }
        }
    }

    private final class BackStackObserver implements BackStack.Observer {

        @Override public void onChanged(int count) {

            if (count == 0) backCommand();
        }
    }
}
