package com.dev.rosty.lepka.sample.presentation.screens.picker

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dev.rosty.lepka.sample.R
import com.dev.rosty.lepka.sample.databinding.FragmentPickerBinding
import com.dev.rosty.lepka.sample.presentation.base.ScreenFragment


class PickerFragment : ScreenFragment<PickerViewModel, FragmentPickerBinding>() {

    override fun getViewModelClass() = PickerViewModel::class.java

    override fun inflateBinding(inflater: LayoutInflater?, container: ViewGroup?, state: Bundle?) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_picker, container, false)
        binding.viewModel = viewModel;
    }
}