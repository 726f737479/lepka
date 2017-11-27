package com.dev.rosty.lepka.lib.entity.module;

import com.dev.rosty.lepka.lib.Screen;
import com.dev.rosty.lepka.lib.entity.activity.TestActivity2;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen3;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen4;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen7;
import com.dev.rosty.lepka.lib.module.LepkaModule;
import com.dev.rosty.lepka.lib.module.Priority;

/**
 * Created by rosty on 11/26/17.
 */

public class TestModule2 extends LepkaModule {

    @Override public int provideContainer() {
        return 0;
    }

    @Override public Class getActivityClass() {
        return TestActivity2.class;
    }

    @Override public boolean canOpen(Screen screen) {

        return screen instanceof TestScreen3
                || screen instanceof TestScreen4
                || screen instanceof TestScreen7;
    }

    @Override public int getPriority(Screen screen) {
        return screen instanceof TestScreen7 ? Priority.MEDIUM : Priority.HIGH;
    }
}
