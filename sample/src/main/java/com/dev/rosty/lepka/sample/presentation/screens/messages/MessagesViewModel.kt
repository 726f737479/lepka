package com.dev.rosty.lepka.sample.presentation.screens.messages

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.lib.command.Forward
import com.dev.rosty.lepka.sample.ChatScreen
import com.dev.rosty.lepka.sample.injection.screen.ScreenComponent
import javax.inject.Inject


class MessagesViewModel : ViewModel(), ScreenComponent.Injectable {

    @Inject lateinit var lepka: Lepka

    val empties = ObservableArrayList<String>()


    override fun inject(screenComponent: ScreenComponent) {

        screenComponent.inject(this)

        for (i in 1..20) empties.add("Chat " + i)
    }


    fun onEmptySelected(name: String) = lepka.execute(Forward(ChatScreen(name)))
}