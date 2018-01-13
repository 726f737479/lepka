package com.dev.rosty.lepka.sample.injection.screen

import android.os.Bundle
import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.sample.EXTRA_COUNT
import com.dev.rosty.lepka.sample.EXTRA_TITLE
import dagger.Module
import dagger.Provides


@Module class ScreenModule(val extras: Bundle) {

    @Provides fun provideScreenDataTitle(): String {

        return extras.getString(EXTRA_TITLE)
    }

    @Provides fun provideScreenDataCount(): Number {

        return extras.getInt(EXTRA_COUNT)
    }
}
