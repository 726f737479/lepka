package com.dev.rosty.lepka.lib.transition;

import android.view.View;

import com.dev.rosty.lepka.lib.Screen;

/**
 * You should implement your {@link android.app.Activity}
 * or {@link android.support.v7.app.AppCompatActivity} from this abstraction if you wants to
 * add shared element transaction between your {@link Screen}'s
 */
public interface SharedElementManager {

    /**
     * This methods return SharedElement {@link View} which will be used in
     * transaction
     *
     * @return A View in a disappearing Fragment to match with a View in an
     *         appearing Fragment.
     */
    View produceSharedElement();
}
