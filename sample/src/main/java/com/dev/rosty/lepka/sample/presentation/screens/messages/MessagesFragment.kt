package com.dev.rosty.lepka.sample.presentation.screens.messages

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dev.rosty.lepka.sample.R
import com.dev.rosty.lepka.sample.databinding.FragmentMessagesBinding
import com.dev.rosty.lepka.sample.presentation.base.adapter.ItemAction
import com.dev.rosty.lepka.sample.presentation.base.ScreenFragment


class MessagesFragment : ScreenFragment<MessagesViewModel, FragmentMessagesBinding>() {

    override fun getViewModelClass() = MessagesViewModel::class.java

    override fun inflateBinding(inflater: LayoutInflater?, container: ViewGroup?, state: Bundle?) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_messages, container, false)
        binding.viewModel = viewModel
        binding.empties.adapter = ChatsAdapter(viewModel.empties, ItemAction { viewModel.onEmptySelected(it) })
    }
}