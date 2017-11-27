package com.dev.rosty.lepka.sample.presentation.screens.empty

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.lib.screen.Data
import com.dev.rosty.lepka.lib.command.Back
import com.dev.rosty.lepka.sample.injection.screen.ScreenComponent
import javax.inject.Inject


class EmptyViewModel : ViewModel(), ScreenComponent.Injectable {

    @Inject lateinit var data: Data<String>
    @Inject lateinit var lepka: Lepka

    var title = ObservableField<String> ("")


    override fun inject(screenComponent: ScreenComponent) {

        screenComponent.inject(this)

        title.set(data.get())
    }


    fun onBackTap() = lepka.execute(Back())
}
