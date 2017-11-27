package com.dev.rosty.lepka.lib;

import com.dev.rosty.lepka.lib.screen.Data;

/**
 * Main abstraction of library, must be initialized only once and
 * application must have only single instance for it.
 *
 * To initialized this class you need to use {@link com.dev.rosty.lepka.lib.logic.LepkaBuilder}
 */
public interface Lepka {

    /**
     * This methods is used to navigate throw {@link android.app.Application} using
     * different {@link Command}'s
     *
     * @param command that should be executed
     */
    void execute(Command command);

    /**
     * Extra data that can then be retrieved when the screen opens
     * with {@link Lepka} instance
     *
     * @return extra data that user pass to {@link Screen}
     */

    /**
     * Using this method you can retrieve {@link Data} for specific {@link Screen}
     * by his Key, see {@link com.dev.rosty.lepka.lib.util.KeysUtil}
     *
     * @param screenKey key for {@link Screen} which {@link Data} you wants to retrieve
     * @return {@link Data} of {@link Screen} that associated with given Key
     */
     Data produceScreenData(String screenKey);
}
