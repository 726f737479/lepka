package com.dev.rosty.lepka.lib;

import android.support.annotation.IdRes;

import com.dev.rosty.lepka.lib.module.Priority;

/**
 * Created by rosty on 11/11/17.
 */

public interface Module {

    @IdRes int provideContainer();

    @Priority int getPriority(Screen screen);

    Class getActivityClass();

    boolean canOpen(Screen screen);
}
