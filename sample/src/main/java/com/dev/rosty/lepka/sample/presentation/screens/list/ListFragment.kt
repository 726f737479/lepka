package com.dev.rosty.navi.presentation.screens.purple

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dev.rosty.lepka.sample.R
import com.dev.rosty.lepka.sample.databinding.FragmentListBinding
import com.dev.rosty.lepka.sample.presentation.base.adapter.ItemAction
import com.dev.rosty.lepka.sample.presentation.screens.list.EmptyAdapter
import com.dev.rosty.lepka.sample.presentation.screens.list.ListViewModel
import com.dev.rosty.lepka.sample.presentation.base.ScreenFragment

/**
 * Created by rosty on 11/22/17.
 */

class ListFragment : ScreenFragment<ListViewModel, FragmentListBinding>() {

    override fun getViewModelClass() = ListViewModel::class.java

    override fun inflateBinding(inflater: LayoutInflater?, container: ViewGroup?, state: Bundle?) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        binding.viewModel = viewModel
        binding.empties.adapter = EmptyAdapter(viewModel.empties, ItemAction { viewModel.onEmptySelected(it) })
    }
}