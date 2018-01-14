package com.dev.rosty.lepka.sample.presentation.screens.news

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dev.rosty.lepka.sample.R
import com.dev.rosty.lepka.sample.databinding.FragmentNewsBinding
import com.dev.rosty.lepka.sample.presentation.base.ScreenFragment


class NewsFragment : ScreenFragment<NewsViewModel, FragmentNewsBinding>() {

    override fun getViewModelClass() = NewsViewModel::class.java

    override fun inflateBinding(inflater: LayoutInflater?, container: ViewGroup?, state: Bundle?) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)
        binding.viewModel = viewModel;
    }
}