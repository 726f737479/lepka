package com.dev.rosty.lepka.sample.presentation.screens.chat

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dev.rosty.lepka.sample.R
import com.dev.rosty.lepka.sample.databinding.FragmentChatBinding
import com.dev.rosty.lepka.sample.presentation.base.ScreenFragment


class ChatFragment : ScreenFragment<ChatViewModel, FragmentChatBinding>() {

    override fun getViewModelClass() = ChatViewModel::class.java

    override fun inflateBinding(inflater: LayoutInflater?, container: ViewGroup?, state: Bundle?) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat, container, false)
        binding.viewModel = viewModel
    }
}
