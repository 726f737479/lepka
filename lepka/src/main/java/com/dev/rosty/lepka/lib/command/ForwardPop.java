package com.dev.rosty.lepka.lib.command;

import com.dev.rosty.lepka.lib.Command;
import com.dev.rosty.lepka.lib.Screen;


public final class ForwardPop implements Command {

    public final Screen screen;

    public ForwardPop(Screen screen) {
        this.screen = screen;
    }
}
