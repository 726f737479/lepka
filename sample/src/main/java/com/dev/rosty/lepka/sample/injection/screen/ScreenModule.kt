package com.dev.rosty.lepka.sample.injection.screen

import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.lib.screen.Data
import dagger.Module
import dagger.Provides

/**
 * Created by rosty on 11/24/17.
 */

@Module class ScreenModule(@ScreenKey val key: String) {

    @Provides
    @ScreenKey
    fun provideScreenKey() = key

    @Provides
    fun provideScreenDataString(lepka: Lepka, @ScreenKey key: String): Data<String> {

        return lepka.produceScreenData(key) as Data<String>
    }

    @Provides
    fun provideScreenDataInt(lepka: Lepka, @ScreenKey key: String): Data<Int> {

        return lepka.produceScreenData(key) as Data<Int>
    }
}
