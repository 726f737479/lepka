package com.dev.rosty.lepka.sample.injection.screen

import android.os.Bundle
import com.dev.rosty.lepka.sample.*
import dagger.Module
import dagger.Provides


@Module class ScreenModule(private val extras: Bundle) {

    @Provides
    @ScreenKey(ScreenType.CHAT)
    fun provideScreenChatTitle() = extras.getString(EXTRA_CHAT_TITLE)

    @Provides
    @ScreenKey(ScreenType.PAGE)
    fun provideScreenPageTitle() = extras.getString(EXTRA_PAGE_TITLE)

    @Provides
    @ScreenKey(ScreenType.PAGE)
    fun provideScreenPageCount(): Number {

        return extras.getInt(EXTRA_PAGE_COUNT)
    }
}
