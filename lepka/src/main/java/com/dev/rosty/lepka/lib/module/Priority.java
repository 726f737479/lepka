package com.dev.rosty.lepka.lib.module;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.dev.rosty.lepka.lib.module.Priority.HIGH;
import static com.dev.rosty.lepka.lib.module.Priority.LOW;
import static com.dev.rosty.lepka.lib.module.Priority.MEDIUM;

/**
 * Annotation that is used to group priorities, that is used
 * in {@link com.dev.rosty.lepka.lib.Module} to resolved {@link com.dev.rosty.lepka.lib.Screen}
 * collisions
 */
@IntDef({ HIGH, MEDIUM, LOW })
@Retention(RetentionPolicy.SOURCE)
public @interface Priority {

    int HIGH   = 0;
    int MEDIUM = 1;
    int LOW    = 2;
}