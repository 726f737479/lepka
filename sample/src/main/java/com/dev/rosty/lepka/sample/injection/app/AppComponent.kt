package com.dev.rosty.lepka.sample.injection.app

import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.sample.presentation.modules.BotBarActivity
import com.dev.rosty.lepka.sample.presentation.modules.ListActivity
import com.dev.rosty.lepka.sample.presentation.modules.SplashActivity
import com.dev.rosty.lepka.sample.SampleApp

import javax.inject.Singleton

import dagger.Component


@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(application: SampleApp)

    fun inject(activity: BotBarActivity)
    fun inject(activity: SplashActivity)
    fun inject(activity: ListActivity)

    interface Injectable {

        fun inject(appComponent: AppComponent)
    }

    fun lepka(): Lepka
}
