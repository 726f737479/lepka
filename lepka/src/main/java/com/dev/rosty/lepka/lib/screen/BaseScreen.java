package com.dev.rosty.lepka.lib.screen;


import com.dev.rosty.lepka.lib.Screen;

/**
 * Base implementation of {@link Screen}, sets default {@link Data}
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
