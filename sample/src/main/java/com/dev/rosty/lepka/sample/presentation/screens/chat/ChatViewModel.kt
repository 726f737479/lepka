package com.dev.rosty.lepka.sample.presentation.screens.chat

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.lib.command.Back
import com.dev.rosty.lepka.sample.injection.screen.ScreenComponent
import com.dev.rosty.lepka.sample.injection.screen.ScreenKey
import com.dev.rosty.lepka.sample.injection.screen.ScreenType
import javax.inject.Inject


class ChatViewModel : ViewModel(), ScreenComponent.Injectable {

    @Inject @field:ScreenKey(ScreenType.CHAT) lateinit var title: String

    @Inject lateinit var lepka: Lepka

    var titleField = ObservableField<String> ("")


    override fun inject(screenComponent: ScreenComponent) {

        screenComponent.inject(this)

        titleField.set(title)
    }


    fun onBackTap() = lepka.execute(Back())
}
