package com.dev.rosty.lepka.sample.presentation.screens.add

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dev.rosty.lepka.sample.R
import com.dev.rosty.lepka.sample.databinding.FragmentAddBinding
import com.dev.rosty.lepka.sample.presentation.base.ScreenFragment


class AddFragment : ScreenFragment<AddViewModel, FragmentAddBinding>() {

    override fun getViewModelClass() = AddViewModel::class.java

    override fun inflateBinding(inflater: LayoutInflater?, container: ViewGroup?, state: Bundle?) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false)
        binding.viewModel = viewModel
    }
}
