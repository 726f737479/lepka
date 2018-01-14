package com.dev.rosty.lepka.sample.presentation.screens.account

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dev.rosty.lepka.sample.R
import com.dev.rosty.lepka.sample.databinding.FragmentAccountBinding
import com.dev.rosty.lepka.sample.presentation.base.ScreenFragment


class AccountFragment : ScreenFragment<AccountViewModel, FragmentAccountBinding>() {

    override fun getViewModelClass() = AccountViewModel::class.java

    override fun inflateBinding(inflater: LayoutInflater?, container: ViewGroup?, state: Bundle?) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false)
        binding.viewModel = viewModel
    }
}
