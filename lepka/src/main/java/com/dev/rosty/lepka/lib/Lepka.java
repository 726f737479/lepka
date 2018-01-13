package com.dev.rosty.lepka.lib;


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
}
