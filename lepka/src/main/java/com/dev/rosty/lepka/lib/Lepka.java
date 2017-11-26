package com.dev.rosty.lepka.lib;


import com.dev.rosty.lepka.lib.screen.Data;

/**
 * Created by rosty on 11/11/17.
 */

public interface Lepka {

    void execute(Command command);

    Data produceScreenData(String screenKey);
}
