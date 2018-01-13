package com.dev.rosty.lepka.lib.logic.executor;

import android.app.Activity;

import com.dev.rosty.lepka.lib.Module;
import com.dev.rosty.lepka.lib.Screen;


public interface Executor {

    void setup(Activity activity);

    void openScreen(Module module, Screen screen, boolean clear);
    void openRouter(Module module, boolean clear);

    void closeScreen();
    void closeRouter();

    boolean popScreensTo(Screen screen);
}
