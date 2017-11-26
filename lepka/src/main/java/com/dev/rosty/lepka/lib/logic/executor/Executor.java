package com.dev.rosty.lepka.lib.logic.executor;

import android.app.Activity;

import com.dev.rosty.lepka.lib.Module;
import com.dev.rosty.lepka.lib.Screen;

/**
 * Created by rosty on 11/25/17.
 */

public interface Executor {

    void setup(Activity activity);

    void openScreen(Module module, Screen screen, String key);
    void openRouter(Module module, String key);

    void closeScreen();
    void closeRouter();
}
