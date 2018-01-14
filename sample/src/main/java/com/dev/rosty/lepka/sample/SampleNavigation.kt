package com.dev.rosty.lepka.sample

import com.dev.rosty.lepka.lib.Screen
import com.dev.rosty.lepka.lib.module.LepkaModule
import com.dev.rosty.lepka.lib.screen.LepkaScreen
import com.dev.rosty.lepka.sample.presentation.modules.HomeActivity
import com.dev.rosty.lepka.sample.presentation.modules.ChatActivity
import com.dev.rosty.lepka.sample.presentation.modules.AuthorizationActivity
import com.dev.rosty.lepka.sample.presentation.screens.chat.ChatFragment
import com.dev.rosty.lepka.sample.presentation.screens.account.AccountFragment
import com.dev.rosty.lepka.sample.presentation.screens.login.LoginFragment
import com.dev.rosty.lepka.sample.presentation.screens.messages.MessagesFragment
import com.dev.rosty.lepka.sample.presentation.screens.news.NewsFragment
import com.dev.rosty.lepka.sample.presentation.screens.page.PageFragment


class AuthorizationModule : LepkaModule() {

    override fun provideContainer() = R.id.container

    override fun getActivityClass() = AuthorizationActivity::class.java

    override fun canOpen(screen: Screen) = screen is LoginScreen
}

class HomeModule : LepkaModule() {

    override fun provideContainer() = R.id.container

    override fun getActivityClass() = HomeActivity::class.java

    override fun canOpen(screen: Screen) = screen is NewsScreen
            || screen is PageScreen
            || screen is MessagesScreen
            || screen is AccountScreen
}

class ChatModule : LepkaModule() {

    override fun provideContainer()= R.id.container

    override fun getActivityClass() = ChatActivity::class.java

    override fun canOpen(screen: Screen) = screen is ChatScreen
}

object LoginScreen : LepkaScreen(LoginFragment::class.java)

object NewsScreen : LepkaScreen(NewsFragment::class.java)

object MessagesScreen : LepkaScreen(MessagesFragment::class.java)

object AccountScreen : LepkaScreen(AccountFragment::class.java)

class PageScreen(title: String, count: Int) : LepkaScreen(PageFragment::class.java) {

    init {
        data.putString(EXTRA_PAGE_TITLE, title)
        data.putInt(EXTRA_PAGE_COUNT, count)
    }
}

class ChatScreen(title: String) : LepkaScreen(ChatFragment::class.java) {

    init { data.putString(EXTRA_CHAT_TITLE, title) }
}

const val EXTRA_PAGE_COUNT = "page_count"
const val EXTRA_PAGE_TITLE = "page_tile"
const val EXTRA_CHAT_TITLE = "chat_title"
