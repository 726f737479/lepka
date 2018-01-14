package com.dev.rosty.lepka.sample.injection.screen

import com.dev.rosty.lepka.sample.injection.app.AppComponent
import com.dev.rosty.lepka.sample.presentation.screens.account.AccountViewModel
import com.dev.rosty.lepka.sample.presentation.screens.login.LoginViewModel
import com.dev.rosty.lepka.sample.presentation.screens.chat.ChatViewModel
import com.dev.rosty.lepka.sample.presentation.screens.messages.MessagesViewModel
import com.dev.rosty.lepka.sample.presentation.screens.news.NewsViewModel
import com.dev.rosty.lepka.sample.presentation.screens.page.PageViewModel
import dagger.Component


@ScreenScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ScreenModule::class))
interface ScreenComponent {

    fun inject(viewModel: ChatViewModel)
    fun inject(viewModel: AccountViewModel)
    fun inject(viewModel: LoginViewModel)
    fun inject(viewModel: MessagesViewModel)
    fun inject(viewModel: PageViewModel)
    fun inject(viewModel: NewsViewModel)

    interface Injectable {

        fun inject(screenComponent: ScreenComponent)
    }

//    @ScreenKey fun chatTitle(): String
//    @ScreenKeyPage fun pageTitle(): String
//    @ScreenKeyPage fun pageCount(): Number
}
