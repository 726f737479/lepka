package com.dev.rosty.lepka.lib.entity.module;

import com.dev.rosty.lepka.lib.Screen;
import com.dev.rosty.lepka.lib.entity.activity.TestActivity3;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen5;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen6;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen7;
import com.dev.rosty.lepka.lib.module.BaseModule;

/**
 * Created by rosty on 11/26/17.
 */

public class TestModule3 extends BaseModule {

    @Override public int provideContainer() {
        return 0;
    }

    @Override public Class getActivityClass() {
        return TestActivity3.class;
    }

    @Override public boolean canOpen(Screen screen) {

        return screen instanceof TestScreen5
                || screen instanceof TestScreen6
                || screen instanceof TestScreen7;
    }
}
