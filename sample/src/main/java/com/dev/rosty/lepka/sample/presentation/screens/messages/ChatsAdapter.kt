package com.dev.rosty.lepka.sample.presentation.screens.messages

import android.databinding.ObservableList

import com.dev.rosty.lepka.sample.R
import com.dev.rosty.lepka.sample.databinding.ItemChatBinding
import com.dev.rosty.lepka.sample.presentation.base.adapter.ItemAction
import com.dev.rosty.lepka.sample.presentation.base.adapter.ItemViewHolder
import com.dev.rosty.lepka.sample.presentation.base.adapter.ListAdapter


class ChatsAdapter(data: ObservableList<String>, private val action: ItemAction<String>) : ListAdapter<String, ItemChatBinding>(data) {

    override val layoutRes = R.layout.item_chat

    override fun onBindViewHolder(holder: ItemViewHolder<ItemChatBinding>, position: Int) {

        holder.binding.isLast = itemCount == position + 1
        holder.binding.name   = data[position]
        holder.binding.action = action
    }
}
