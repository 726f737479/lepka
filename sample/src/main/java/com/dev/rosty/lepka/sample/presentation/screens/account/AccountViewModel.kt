package com.dev.rosty.lepka.sample.presentation.screens.account

import android.arch.lifecycle.ViewModel
import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.lib.command.ForwardClear
import com.dev.rosty.lepka.sample.AuthorizationScreen
import com.dev.rosty.lepka.sample.injection.screen.ScreenComponent
import javax.inject.Inject


class AccountViewModel : ViewModel(), ScreenComponent.Injectable {

    @Inject lateinit var lepka: Lepka


    override fun inject(screenComponent: ScreenComponent)
            = screenComponent.inject(this)


    fun onLogoutClick() = lepka.execute(ForwardClear(AuthorizationScreen))
}
