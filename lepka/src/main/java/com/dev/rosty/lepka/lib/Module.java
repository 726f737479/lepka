package com.dev.rosty.lepka.lib;

import android.support.annotation.IdRes;

import com.dev.rosty.lepka.lib.module.Priority;

/**
 * Abstraction that group {@link Screen} based on some logical principle
 */
public interface Module {

    /**
     * Returns identifier of the container that would be used to for replacing fragments
     *
     * @return identifier of the container where fragment(s) should be placed
     */
    @IdRes int provideContainer();

    /**
     * Returns {@link Priority} for specified {@link Screen}, that would used to define which
     * {@link Module} should be opened for specified {@link Screen}
     *
     * @param screen {@link Screen} that user wants to open
     * @return priority for specified {@link Screen} in this {@link Module}
     */
    @Priority int getPriority(Screen screen);

    /**
     * This method used to initialize {@link android.content.Intent}
     * that associated with this {@link Module}
     *
     * @return The {@link Class} object that should represents the runtime
     *         class of {@link android.app.Activity}
     *         or {@link android.support.v7.app.AppCompatActivity}
     */
    Class getActivityClass();

    /**
     * Indicates whether this {@link Module} can open  specified {@link Screen}
     *
     * @param screen {@link Screen} that user wants to open
     * @return true if can open, false if can't open
     */
    boolean canOpen(Screen screen);
}
