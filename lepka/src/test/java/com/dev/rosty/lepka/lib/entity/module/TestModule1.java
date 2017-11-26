package com.dev.rosty.lepka.lib.entity.module;

import com.dev.rosty.lepka.lib.Screen;
import com.dev.rosty.lepka.lib.entity.activity.TestActivity1;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen1;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen2;
import com.dev.rosty.lepka.lib.module.BaseModule;

/**
 * Created by rosty on 11/26/17.
 */

public class TestModule1 extends BaseModule {

    @Override public int provideContainer() {
        return 0;
    }

    @Override public Class getActivityClass() {
        return TestActivity1.class;
    }

    @Override public boolean canOpen(Screen screen) {
        return screen instanceof TestScreen1 || screen instanceof TestScreen2;
    }
}
