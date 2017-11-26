package com.dev.rosty.lepka.lib.command;

import com.dev.rosty.lepka.lib.Command;
import com.dev.rosty.lepka.lib.Screen;

/**
 * Created by rosty on 11/24/17.
 */

public class BackTo implements Command {

    private Screen screen;

    public BackTo(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }
}
