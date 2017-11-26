package com.dev.rosty.lepka.lib.screen;


import com.dev.rosty.lepka.lib.Screen;

/**
 * Created by rosty on 11/12/17.
 */

public abstract class BaseScreen implements Screen {

    protected Data data;

    public BaseScreen() {
        this(new DataEmpty());
    }

    public BaseScreen(Data data) {
        this.data = data;
    }

    @Override public Data getData() {
        return data;
    }
}
