package com.google.developer.bugmaster.presentation.core

import android.support.v7.util.DiffUtil

class InsectDiffCallback : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemPosition == newItemPosition
    }

    override fun getOldListSize(): Int {
        return 0
    }

    override fun getNewListSize(): Int {
        return 0
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemPosition == newItemPosition
    }
}