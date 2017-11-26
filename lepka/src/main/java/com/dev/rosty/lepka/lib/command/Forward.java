package com.dev.rosty.lepka.lib.command;


import com.dev.rosty.lepka.lib.Command;
import com.dev.rosty.lepka.lib.Screen;

/**
 * Created by rosty on 11/22/17.
 */

public class Forward implements Command {

    private Screen screen;

    public Forward(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }
}
