package com.dev.rosty.lepka.sample.presentation.base.adapter

import android.content.Context
import android.databinding.ObservableList
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import java.lang.ref.WeakReference


abstract class ListAdapter<T, B : ViewDataBinding>(protected var data: ObservableList<T>) : RecyclerView.Adapter<ItemViewHolder<B>>() {

    init { data.addOnListChangedCallback(OnListChangedCallbackImpl(this)) }

    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): ItemViewHolder<B> {

        val layoutInflater = parent.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        return ItemViewHolder(layoutInflater.inflate(layoutRes, parent, false))
    }

    override fun getItemCount(): Int { return data.size }

    @get:LayoutRes protected abstract val layoutRes: Int

    private inner class OnListChangedCallbackImpl<T> constructor(adapter: ListAdapter<T, B>) : ObservableList.OnListChangedCallback<ObservableList<T>>() {

        private val adapterWeakReference: WeakReference<ListAdapter<T, B>>

        init { this.adapterWeakReference = WeakReference<ListAdapter<T, B>>(adapter) }

        override fun onChanged(items: ObservableList<T>) { notifyDataSetChanged() }

        override fun onItemRangeChanged(items: ObservableList<T>, positionStart: Int, itemCount: Int) {

            adapterWeakReference.get()?.notifyItemRangeChanged(positionStart, itemCount)
        }

        override fun onItemRangeInserted(items: ObservableList<T>, positionStart: Int, itemCount: Int) {

            adapterWeakReference.get()?.notifyItemRangeInserted(positionStart, itemCount)
        }

        override fun onItemRangeMoved(items: ObservableList<T>, fromPosition: Int, toPosition: Int, itemCount: Int) {

            adapterWeakReference.get()?.notifyItemMoved(fromPosition, toPosition)
        }

        override fun onItemRangeRemoved(items: ObservableList<T>, positionStart: Int, itemCount: Int) {

            adapterWeakReference.get()?.notifyItemRangeChanged(positionStart, itemCount)
        }
    }
}
