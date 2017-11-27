package com.dev.rosty.lepka.lib.screen;

import com.dev.rosty.lepka.lib.Screen;


/**
 * Base implementation of {@link Screen}, sets default {@link Data}
 */
public class LepkaScreen implements Screen {

    private final Class clazz;
    private final Data data;

    public LepkaScreen(Class clazz) {
        this(clazz, new DataEmpty());
    }

    public LepkaScreen(Class clazz, Data data) {
        this.clazz = clazz;
        this.data = data;
    }

    @Override public Class getFragmentClass() {
        return clazz;
    }

    @Override public Data getData() {
        return data;
    }
}
