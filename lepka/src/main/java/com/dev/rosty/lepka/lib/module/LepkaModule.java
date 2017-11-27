package com.dev.rosty.lepka.lib.module;

import com.dev.rosty.lepka.lib.Module;
import com.dev.rosty.lepka.lib.Screen;


/**
 * Base implementation of {@link Module}, sets default priority
 */
public abstract class LepkaModule implements Module {

    @Override public int getPriority(Screen screen) {
        return Priority.HIGH;
    }
}
