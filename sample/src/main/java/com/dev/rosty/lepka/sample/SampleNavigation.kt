package com.dev.rosty.lepka.sample

import com.dev.rosty.lepka.lib.Screen
import com.dev.rosty.lepka.lib.router.BaseModule
import com.dev.rosty.lepka.lib.router.Priority
import com.dev.rosty.lepka.lib.screen.Data
import com.dev.rosty.lepka.lib.screen.BaseScreen
import com.dev.rosty.lepka.sample.presentation.modules.BotBarActivity
import com.dev.rosty.lepka.sample.presentation.modules.ListActivity
import com.dev.rosty.lepka.sample.presentation.modules.SplashActivity
import com.dev.rosty.lepka.sample.presentation.screens.empty.EmptyFragment
import com.dev.rosty.lepka.sample.presentation.screens.add.AddFragment
import com.dev.rosty.navi.presentation.screens.purple.ListFragment
import com.dev.rosty.lepka.sample.presentation.screens.picker.PickerFragment

/**
 * Created by rosty on 11/22/17.
 */

class SplashModule : BaseModule() {

    override fun provideContainer() = R.id.container

    override fun getActivityClass() = SplashActivity::class.java

    override fun canOpen(screen: Screen) = screen is PickerScreen
}

class BotBarModule : BaseModule() {

    override fun provideContainer() = R.id.container

    override fun getActivityClass() = BotBarActivity::class.java

    override fun canOpen(screen: Screen) = screen is AddScreen

    override fun getPriority(screen: Screen)
            = if (screen is AddScreen) Priority.MEDIUM else Priority.HIGH
}

class ListModule : BaseModule() {

    override fun provideContainer()= R.id.container

    override fun getActivityClass() = ListActivity::class.java

    override fun canOpen(screen: Screen)
            = screen is ListScreen || screen is EmptyScreen
}

class ListScreen : BaseScreen() {

    override fun getFragmentClass() = ListFragment::class.java
}

class AddScreen(data: Data<Int>) : BaseScreen(data) {

    override fun getFragmentClass() = AddFragment::class.java
}

class PickerScreen : BaseScreen() {

    override fun getFragmentClass() = PickerFragment::class.java
}

class EmptyScreen(data: Data<String>) : BaseScreen(data) {

    override fun getFragmentClass() = EmptyFragment::class.java
}
