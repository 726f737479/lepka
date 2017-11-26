package com.dev.rosty.lepka.sample.presentation.base.adapter


import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View


class ItemViewHolder<B : ViewDataBinding> internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val binding: B

    init { binding = DataBindingUtil.bind<B>(itemView) }
}