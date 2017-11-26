package com.dev.rosty.lepka.lib.entity.screen;

import com.dev.rosty.lepka.lib.entity.fragment.TestFragment1;
import com.dev.rosty.lepka.lib.screen.BaseScreen;

/**
 * Created by rosty on 11/26/17.
 */

public class TestScreen1 extends BaseScreen {

    @Override public Class getFragmentClass() {
        return TestFragment1.class;
    }
}
