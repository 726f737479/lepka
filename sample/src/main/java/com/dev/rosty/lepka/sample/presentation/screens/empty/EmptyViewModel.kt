package com.dev.rosty.lepka.sample.presentation.screens.empty

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.lib.command.BackTo
import com.dev.rosty.lepka.sample.PickerScreen
import com.dev.rosty.lepka.sample.injection.screen.ScreenComponent
import javax.inject.Inject


class EmptyViewModel : ViewModel(), ScreenComponent.Injectable {

    @Inject lateinit var title: String
    @Inject lateinit var lepka: Lepka

    var titleField = ObservableField<String> ("")


    override fun inject(screenComponent: ScreenComponent) {

        screenComponent.inject(this)

        titleField.set(title)
    }


    fun onBackTap() = lepka.execute(BackTo(PickerScreen))
}
