package com.dev.rosty.lepka.sample.injection.screen

import com.dev.rosty.lepka.sample.injection.app.AppComponent
import com.dev.rosty.lepka.sample.presentation.screens.add.AddViewModel
import com.dev.rosty.lepka.sample.presentation.screens.empty.EmptyViewModel
import com.dev.rosty.lepka.sample.presentation.screens.list.ListViewModel
import com.dev.rosty.lepka.sample.presentation.screens.picker.PickerViewModel
import dagger.Component


@ScreenScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ScreenModule::class))
interface ScreenComponent {

    fun inject(viewModel: EmptyViewModel)
    fun inject(viewModel: AddViewModel)
    fun inject(viewModel: PickerViewModel)
    fun inject(viewModel: ListViewModel)

    interface Injectable {

        fun inject(screenComponent: ScreenComponent)
    }
}
