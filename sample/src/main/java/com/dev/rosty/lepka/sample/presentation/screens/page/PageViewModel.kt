package com.dev.rosty.lepka.sample.presentation.screens.page

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.lib.command.Back
import com.dev.rosty.lepka.lib.command.BackTo
import com.dev.rosty.lepka.lib.command.Forward
import com.dev.rosty.lepka.sample.NewsScreen
import com.dev.rosty.lepka.sample.PageScreen
import com.dev.rosty.lepka.sample.injection.screen.ScreenComponent
import com.dev.rosty.lepka.sample.injection.screen.ScreenKey
import com.dev.rosty.lepka.sample.injection.screen.ScreenType
import javax.inject.Inject


class PageViewModel : ViewModel(), ScreenComponent.Injectable {

    @Inject @field:ScreenKey(ScreenType.PAGE) lateinit var count: Number
    @Inject @field:ScreenKey(ScreenType.PAGE) lateinit var title: String

    @Inject lateinit var lepka: Lepka

    val countField = ObservableField ("")
    val titleField = ObservableField ("")

    val hasNextPage = ObservableBoolean(true)
    val hasPrevPage = ObservableBoolean(true)


    override fun inject(screenComponent: ScreenComponent) {

        screenComponent.inject(this)

        countField.set(count.toString())
        titleField.set(title)

        hasNextPage.set(count.toInt() < 10)
        hasPrevPage.set(count.toInt() > 1)
    }


    fun onNextClick() = lepka.execute(Forward(PageScreen(title, count.toInt() + 1)))
    fun onPrevClick() = lepka.execute(Back())
    fun onCloseClick() = lepka.execute(BackTo(NewsScreen))
}
