package com.dev.rosty.lepka.sample.presentation.screens.login

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dev.rosty.lepka.sample.R
import com.dev.rosty.lepka.sample.databinding.FragmentLoginBinding
import com.dev.rosty.lepka.sample.presentation.base.ScreenFragment


class LoginFragment : ScreenFragment<LoginViewModel,FragmentLoginBinding>() {

    override fun getViewModelClass() = LoginViewModel::class.java

    override fun inflateBinding(inflater: LayoutInflater?, container: ViewGroup?, state: Bundle?) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.viewModel = viewModel;
    }
}