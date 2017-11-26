package com.dev.rosty.lepka.sample.presentation.screens.list

import android.databinding.ObservableList

import com.dev.rosty.lepka.sample.R
import com.dev.rosty.lepka.sample.databinding.ItemEmptyBinding
import com.dev.rosty.lepka.sample.presentation.base.adapter.ItemAction
import com.dev.rosty.lepka.sample.presentation.base.adapter.ItemViewHolder
import com.dev.rosty.lepka.sample.presentation.base.adapter.ListAdapter

/**
 * Created by rosty on 11/23/17.
 */

class EmptyAdapter(data: ObservableList<String>, private val action: ItemAction<String>) : ListAdapter<String, ItemEmptyBinding>(data) {

    override val layoutRes = R.layout.item_empty

    override fun onBindViewHolder(holder: ItemViewHolder<ItemEmptyBinding>, position: Int) {

        holder.binding.isLast = itemCount == position + 1
        holder.binding.name   = data[position]
        holder.binding.action = action
    }
}
