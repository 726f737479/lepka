package com.dev.rosty.lepka.lib.transition;


import android.app.FragmentTransaction;

import com.dev.rosty.lepka.lib.Screen;


/**
 * You should implement your {@link android.app.Activity} from this abstraction
 * if you wants to customize transaction between your {@link Screen}'s
 */
public interface TransactionManagerDefault {

    /**
     * Using this interface you can add custom params to transaction between {@link Screen}'s
     *
     * @param transaction that will be used to change {@link Screen}'s
     */
    void manage(FragmentTransaction transaction);
}
