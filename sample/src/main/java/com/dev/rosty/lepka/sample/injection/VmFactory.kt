package com.dev.rosty.lepka.sample.injection

import android.app.Activity
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v4.app.Fragment
import com.dev.rosty.lepka.sample.injection.app.AppComponent
import com.dev.rosty.lepka.sample.injection.screen.DaggerScreenComponent
import com.dev.rosty.lepka.sample.injection.screen.ScreenComponent
import com.dev.rosty.lepka.sample.injection.screen.ScreenModule
import com.dev.rosty.lepka.sample.SampleApp


class VmFactory(private val application: Application, private val extras: Bundle)

    : ViewModelProvider.NewInstanceFactory() {

    constructor(activity: Activity) : this(activity.application, activity.intent.extras)

    constructor(fragment: Fragment) : this(fragment.activity.application, fragment.arguments)

    override fun <VM : ViewModel> create(modelClass: Class<VM>): VM {

        val viewModel = super.create(modelClass)

        if (viewModel is ScreenComponent.Injectable) {

            val screenComponent = DaggerScreenComponent.builder()
                    .screenModule(ScreenModule(extras))
                    .appComponent((application as SampleApp).appComponent)
                    .build()

            viewModel.inject(screenComponent)
        }

        if (viewModel is AppComponent.Injectable)
            viewModel.inject((application as SampleApp).appComponent)

        return viewModel
    }
}
