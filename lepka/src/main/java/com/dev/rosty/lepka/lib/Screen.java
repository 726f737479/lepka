package com.dev.rosty.lepka.lib;


import android.os.Bundle;

/**
 * Abstraction that represent specific logical part of the application.
 * Implementation based on Fragments API.
 */
public interface Screen {

    /**
     * This method used to initialize {@link android.app.Fragment}
     * or {@link android.support.v4.app.Fragment} instance that associated with this {@link Screen}
     *
     * @return The {@link Class} object that should represents the runtime
     *         class of {@link android.app.Fragment} or {@link android.support.v4.app.Fragment}
     */
    Class getFragmentClass();

    /**
     * Extra data that can then be retrieved when the screen opens
     * with {@link Lepka} instance
     *
     * @return extra data that user pass to {@link Screen}
     */
    Bundle getData();
}
