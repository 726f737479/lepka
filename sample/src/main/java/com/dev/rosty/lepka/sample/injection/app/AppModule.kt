package com.dev.rosty.lepka.sample.injection.app


import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.lib.logic.LepkaBuilder
import com.dev.rosty.lepka.sample.*
import com.dev.rosty.navi.SampleApp
import dagger.Module

import javax.inject.Singleton

import dagger.Provides
import java.util.*


@Module
class AppModule(val app: SampleApp) {

    @Singleton
    @Provides
    fun provideLepka(): Lepka {

        val modules = Arrays.asList<com.dev.rosty.lepka.lib.Module>(

                SplashModule(),
                BotBarModule(),
                ListModule())

        return LepkaBuilder()
                .setApplication(app)
                .setUseSupport(true)
                .registerModules(modules)
                .setEntryScreen(PickerScreen())
                .build()
    }
}
