package com.google.developer.bugmaster.presentation.core

import android.support.v7.util.DiffUtil

abstract class BaseDiffUtil<in T> {

    abstract fun itemsTheSame(oldItem: T, newItem: T): Boolean

    abstract fun contentsTheSame(oldItem: T, newItem: T): Boolean

    fun callback(oldItems: List<T>, newItems: List<T>) = object : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return itemsTheSame(oldItems[oldItemPosition], newItems[newItemPosition])
        }

        override fun getOldListSize(): Int {
            return oldItems.size
        }

        override fun getNewListSize(): Int {
            return newItems.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return contentsTheSame(oldItems[oldItemPosition], newItems[newItemPosition])
        }
    }
}
