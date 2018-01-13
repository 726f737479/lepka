package com.dev.rosty.lepka.lib.logic;

import android.app.Application;
import android.support.annotation.VisibleForTesting;

import com.dev.rosty.lepka.lib.Lepka;
import com.dev.rosty.lepka.lib.Module;
import com.dev.rosty.lepka.lib.Screen;
import com.dev.rosty.lepka.lib.logic.backstack.BackStack;
import com.dev.rosty.lepka.lib.logic.backstack.BackStackDefault;
import com.dev.rosty.lepka.lib.logic.backstack.BackStackSupport;
import com.dev.rosty.lepka.lib.logic.executor.Executor;
import com.dev.rosty.lepka.lib.logic.executor.ExecutorDefault;
import com.dev.rosty.lepka.lib.logic.executor.ExecutorSupport;

import java.util.List;


public final class LepkaBuilder {

    @VisibleForTesting List<Module> modules;
    @VisibleForTesting Screen screen;
    @VisibleForTesting Application application;

    @VisibleForTesting boolean useSupport;

    public LepkaBuilder registerModules(List<Module> modules) {

        this.modules = modules;
        return this;
    }

    public LepkaBuilder setEntryScreen(Screen screen) {

        this.screen = screen;
        return this;
    }

    public LepkaBuilder setApplication(Application application) {

        this.application = application;
        return this;
    }

    public LepkaBuilder setUseSupport(boolean useSupport) {

        this.useSupport = useSupport;
        return this;
    }

    public Lepka build() {

        if (application == null) throw new RuntimeException("No application");
        if (modules == null) throw new RuntimeException("No modules");
        if (screen == null) throw new RuntimeException("No entry forward");

        ModulesPool modulesPool = new ModulesPool(modules);
        DataHeap dataHeap = new DataHeap();

        Executor executor = useSupport
                ? new ExecutorSupport()
                : new ExecutorDefault();

        BackStack backStack = useSupport
                ? new BackStackSupport()
                : new BackStackDefault();

        return new LepkaImpl(application, screen, executor, modulesPool, backStack, dataHeap);
    }
}
