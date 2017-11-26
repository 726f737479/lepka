package com.dev.rosty.lepka.lib.screen;

/**
 * Created by rosty on 11/22/17.
 */

public class Data<T> {

    private T data;

    public Data(T data) {
        this.data = data;
    }

    public T get() {
        return data;
    }
}
