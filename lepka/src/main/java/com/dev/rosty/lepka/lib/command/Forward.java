package com.dev.rosty.lepka.lib.command;


import android.support.annotation.NonNull;

import com.dev.rosty.lepka.lib.Command;
import com.dev.rosty.lepka.lib.Screen;

/**
 * This is {@link Command} using which user can navigates
 * to next {@link com.dev.rosty.lepka.lib.Screen}
 *
 * If current {@link com.dev.rosty.lepka.lib.Module} can open {@link Screen},
 * {@link Screen} will be opened in a same module.
 *
 * If current {@link com.dev.rosty.lepka.lib.Module} can't open {@link Screen},
 * {@link Screen} will be opened in module that can do this.
 *
 * If no {@link com.dev.rosty.lepka.lib.Module} can open {@link Screen}
 * user will get {@link RuntimeException}
 */
public class Forward implements Command {

    private Screen screen;

    public Forward(@NonNull Screen screen) {
        this.screen = screen;
    }

    /**
     * Return {@link Screen} that should be opened, used by library
     *
     * @return {@link Screen} that should be opened
     */
    public Screen getScreen() {
        return screen;
    }
}
