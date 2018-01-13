package com.dev.rosty.lepka.sample.presentation.screens.add

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.lib.command.Forward
import com.dev.rosty.lepka.lib.command.ForwardClear
import com.dev.rosty.lepka.sample.AddScreen
import com.dev.rosty.lepka.sample.injection.screen.ScreenComponent
import javax.inject.Inject


class AddViewModel : ViewModel(), ScreenComponent.Injectable {

    @Inject lateinit var count: Number
    @Inject lateinit var lepka: Lepka

    var countFuild = ObservableField ("")


    override fun inject(screenComponent: ScreenComponent) {

        screenComponent.inject(this)

        countFuild.set(count.toString())
    }


    fun onAddTap() {

        lepka.execute(
                if (count.toInt() < 5) Forward(AddScreen(count.toInt() + 1))
                else ForwardClear(AddScreen(0)))
    }
}
