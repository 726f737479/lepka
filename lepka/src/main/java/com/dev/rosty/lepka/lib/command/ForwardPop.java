package com.dev.rosty.lepka.lib.command;

import com.dev.rosty.lepka.lib.Command;
import com.dev.rosty.lepka.lib.Screen;

/**
 * Created by rosty on 11/24/17.
 */

public class ForwardPop implements Command {

    private Screen screen;

    public ForwardPop(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }
}
