package com.dev.rosty.lepka.sample.presentation.base.adapter


class ItemAction<in T>(val action : (T) -> Unit) {

    fun invoke(item: T) { action.invoke(item) }
}
