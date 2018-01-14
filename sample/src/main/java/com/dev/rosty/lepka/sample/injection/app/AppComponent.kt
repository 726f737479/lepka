package com.dev.rosty.lepka.sample.injection.app

import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.sample.presentation.modules.HomeActivity
import com.dev.rosty.lepka.sample.SampleApp

import javax.inject.Singleton

import dagger.Component


@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(application: SampleApp)
    fun inject(activity: HomeActivity)

    fun lepka(): Lepka
}
