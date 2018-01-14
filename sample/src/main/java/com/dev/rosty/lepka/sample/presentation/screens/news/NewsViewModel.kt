package com.dev.rosty.lepka.sample.presentation.screens.news

import android.arch.lifecycle.ViewModel
import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.lib.command.Forward
import com.dev.rosty.lepka.sample.PageScreen
import com.dev.rosty.lepka.sample.injection.screen.ScreenComponent
import javax.inject.Inject


class NewsViewModel : ViewModel(), ScreenComponent.Injectable {

    @Inject lateinit var lepka: Lepka

    override fun inject(screenComponent: ScreenComponent)
            = screenComponent.inject(this)

    fun onReadMoreClick(title: String) = lepka.execute(Forward(PageScreen(title, 0)))
}