package com.dev.rosty.lepka.sample.presentation.screens.picker

import android.arch.lifecycle.ViewModel
import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.lib.screen.Data
import com.dev.rosty.lepka.lib.command.Forward
import com.dev.rosty.lepka.sample.AddScreen
import com.dev.rosty.lepka.sample.ListScreen
import com.dev.rosty.lepka.sample.injection.screen.ScreenComponent
import javax.inject.Inject


class PickerViewModel : ViewModel(), ScreenComponent.Injectable {

    @Inject lateinit var lepka: Lepka

    override fun inject(screenComponent: ScreenComponent) = screenComponent.inject(this)


    fun onListTap()   = lepka.execute(Forward(ListScreen))
    fun onBotBarTap() = lepka.execute(Forward(AddScreen(Data(0))))
}