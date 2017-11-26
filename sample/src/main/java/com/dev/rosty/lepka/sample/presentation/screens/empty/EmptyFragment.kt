package com.dev.rosty.lepka.sample.presentation.screens.empty

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dev.rosty.lepka.sample.R
import com.dev.rosty.lepka.sample.databinding.FragmentEmptyBinding
import com.dev.rosty.navi.presentation.screens.ScreenFragment

/**
 * Created by rosty on 11/22/17.
 */

class EmptyFragment : ScreenFragment<EmptyViewModel, FragmentEmptyBinding>() {

    override fun getViewModelClass() = EmptyViewModel::class.java

    override fun inflateBinding(inflater: LayoutInflater?, container: ViewGroup?, state: Bundle?) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_empty, container, false)
        binding.viewModel = viewModel
    }
}
