package com.dev.rosty.lepka.sample.presentation.screens.list

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.lib.command.Forward
import com.dev.rosty.lepka.sample.EmptyScreen
import com.dev.rosty.lepka.sample.injection.screen.ScreenComponent
import javax.inject.Inject


class ListViewModel : ViewModel(), ScreenComponent.Injectable {

    @Inject lateinit var lepka: Lepka

    var empties = ObservableArrayList<String>()


    override fun inject(screenComponent: ScreenComponent) {

        screenComponent.inject(this)

        for (i in 1..20) empties.add("Empty " + i)
    }


    fun onEmptySelected(name: String) = lepka.execute(Forward(EmptyScreen(name)))
}