package com.dev.rosty.lepka.lib.command;

import android.support.annotation.NonNull;

import com.dev.rosty.lepka.lib.Command;
import com.dev.rosty.lepka.lib.Screen;


/**
 * This is {@link Command} using which user can navigates
 * to next {@link com.dev.rosty.lepka.lib.Screen} and clear all back stack
 *
 * If current {@link com.dev.rosty.lepka.lib.Module} can open {@link Screen},
 * {@link Screen} will be opened in a same module
 * and only current module screens back stack will be cleared
 *
 * If current {@link com.dev.rosty.lepka.lib.Module} can't open {@link Screen},
 * {@link Screen} will be opened in module that can do this
 * and all modules back stack will cleared
 *
 * If no {@link com.dev.rosty.lepka.lib.Module} can open {@link Screen}
 * user will get {@link RuntimeException}
 */
public final class ForwardClear implements Command {

    public final Screen screen;

    public ForwardClear(@NonNull Screen screen) {
        this.screen = screen;
    }
}
