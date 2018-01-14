package com.dev.rosty.lepka.sample.injection.app

import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.lib.logic.LepkaBuilder
import com.dev.rosty.lepka.sample.*
import com.dev.rosty.lepka.sample.SampleApp
import dagger.Module

import javax.inject.Singleton

import dagger.Provides


@Module
class AppModule(val app: SampleApp) {

    @Singleton
    @Provides
    fun provideLepka(): Lepka {

        val modules = listOf(

                AuthorizationModule(),
                HomeModule(),
                ChatModule()
        )

        return LepkaBuilder()
                .setApplication(app)
                .setUseSupport(true)
                .registerModules(modules)
                .setEntryScreen(LoginScreen)
                .build()
    }
}
