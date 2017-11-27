package com.dev.rosty.lepka.lib.command;

import com.dev.rosty.lepka.lib.Command;
import com.dev.rosty.lepka.lib.Screen;


public final class BackTo implements Command {

    public final Screen screen;

    public BackTo(Screen screen) {
        this.screen = screen;
    }
}
