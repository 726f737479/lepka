package com.dev.rosty.lepka.lib.router;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.dev.rosty.lepka.lib.router.Priority.HIGH;
import static com.dev.rosty.lepka.lib.router.Priority.LOW;
import static com.dev.rosty.lepka.lib.router.Priority.MEDIUM;

/**
 * Created by rosty on 11/25/17.
 */

@IntDef({ HIGH, MEDIUM, LOW })
@Retention(RetentionPolicy.SOURCE)
public @interface Priority {

    int HIGH   = 0;
    int MEDIUM = 1;
    int LOW    = 2;
}