package com.dev.rosty.lepka.lib.transition;


import android.support.v4.app.FragmentTransaction;

import com.dev.rosty.lepka.lib.Screen;


/**
 * You should implement your {@link android.support.v7.app.AppCompatActivity} from this abstraction
 * if you wants to customize transaction between your {@link Screen}'s
 */
public interface TransactionManagerSupport {

    /**
     * Using this interface you can add custom params to transaction between {@link Screen}'s
     *
     * @param transaction that will be used to change {@link Screen}'s
     */
    void manage(FragmentTransaction transaction);
}
