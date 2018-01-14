package com.dev.rosty.lepka.sample.presentation.modules

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.lib.command.ForwardClear
import com.dev.rosty.lepka.sample.*
import com.dev.rosty.lepka.sample.databinding.ActivityHomeBinding
import com.dev.rosty.lepka.sample.presentation.screens.account.AccountFragment
import com.dev.rosty.lepka.sample.presentation.screens.messages.MessagesFragment
import com.dev.rosty.lepka.sample.presentation.screens.news.NewsFragment
import javax.inject.Inject


class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    @Inject lateinit var lepka: Lepka

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as SampleApp).appComponent.inject(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.bottomNavigation.setOnNavigationItemSelectedListener(this)
    }

    override fun onResume() {
        super.onResume()

        when(supportFragmentManager.findFragmentById(R.id.container)) {

            is NewsFragment -> binding.bottomNavigation.setSelectedItemId(R.id.action_news)
            is MessagesFragment -> binding.bottomNavigation.setSelectedItemId(R.id.action_messages)
            is AccountFragment -> binding.bottomNavigation.setSelectedItemId (R.id.action_account)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.action_news -> lepka.execute(ForwardClear(NewsScreen))
            R.id.action_messages -> lepka.execute(ForwardClear(MessagesScreen))
            R.id.action_account -> lepka.execute(ForwardClear(AccountScreen))
        }

        return true
    }
}
