package com.dev.rosty.lepka.lib.module;

import com.dev.rosty.lepka.lib.Module;
import com.dev.rosty.lepka.lib.Screen;

/**
 * Created by rosty on 11/25/17.
 */

public abstract class BaseModule implements Module {

    @Override public int getPriority(Screen screen) {
        return Priority.HIGH;
    }
}
