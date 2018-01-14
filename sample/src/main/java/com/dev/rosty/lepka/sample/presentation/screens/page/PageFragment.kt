package com.dev.rosty.lepka.sample.presentation.screens.page

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dev.rosty.lepka.sample.R
import com.dev.rosty.lepka.sample.databinding.FragmentPageBinding
import com.dev.rosty.lepka.sample.presentation.base.ScreenFragment


class PageFragment : ScreenFragment<PageViewModel, FragmentPageBinding>() {

    override fun getViewModelClass() = PageViewModel::class.java

    override fun inflateBinding(inflater: LayoutInflater?, container: ViewGroup?, state: Bundle?) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_page, container, false)
        binding.viewModel = viewModel
    }
}
