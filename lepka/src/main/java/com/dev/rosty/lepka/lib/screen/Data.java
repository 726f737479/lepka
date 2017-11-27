package com.dev.rosty.lepka.lib.screen;


/**
 * Entity that hold generic extra data that can be pass via {@link com.dev.rosty.lepka.lib.Screen}
 * can be retrieved when screen is opened
 */
public class Data<T> {

    private T data;

    public Data(T data) {
        this.data = data;
    }

    /**
     * Return generic data casted by specified type
     *
     * @return {@link #data}
     */
    public T get() {
        return data;
    }
}
