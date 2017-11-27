package com.dev.rosty.lepka.lib.command;

import com.dev.rosty.lepka.lib.Command;


/**
 * This is {@link Command} using which user can navigates
 * beck to previous {@link com.dev.rosty.lepka.lib.Screen}
 *
 * If current {@link com.dev.rosty.lepka.lib.Screen} is last in a backstack of
 * {@link com.dev.rosty.lepka.lib.Module}, module will be closed and the previous one with a
 * last {@link com.dev.rosty.lepka.lib.Screen}  will be opened
 *
 * If current {@link com.dev.rosty.lepka.lib.Module} is last in backstack
 * of {@link android.app.Application} and current {@link com.dev.rosty.lepka.lib.Screen}
 * is last in a backstack of {@link com.dev.rosty.lepka.lib.Module} the application closes
 */
public final class Back implements Command { }
