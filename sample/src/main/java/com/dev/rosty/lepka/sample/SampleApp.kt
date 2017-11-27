package com.dev.rosty.lepka.sample

import android.app.Application
import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.sample.injection.app.AppComponent
import com.dev.rosty.lepka.sample.injection.app.AppModule
import com.dev.rosty.lepka.sample.injection.app.DaggerAppComponent
import javax.inject.Inject


class SampleApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    @Inject lateinit var lepka: Lepka

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        appComponent.inject(this)
    }
}
