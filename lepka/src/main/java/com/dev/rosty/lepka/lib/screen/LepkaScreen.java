package com.dev.rosty.lepka.lib.screen;

import android.os.Bundle;

import com.dev.rosty.lepka.lib.Screen;


/**
 * Base implementation of {@link Screen}, sets an empty {@link Bundle} by default
 */
public class LepkaScreen implements Screen {

    private final Class clazz;
    private final Bundle data;

    public LepkaScreen(Class clazz) {
        this(clazz, new Bundle());
    }

    public LepkaScreen(Class clazz, Bundle data) {
        this.clazz = clazz;
        this.data = data;
    }

    @Override public Class getFragmentClass() {
        return clazz;
    }

    @Override public Bundle getData() {
        return data;
    }
}
