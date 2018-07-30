package com.google.developer.bugmaster.presentation.core

import android.support.v7.util.DiffUtil
import com.google.developer.bugmaster.presentation.adapters.InsectAdapterItemType

class InsectDiffCallback(private val oldInsectAdapterItemTypeViewModel: MutableList<InsectAdapterItemType>,
                         private val newInsectAdapterItemTypeViewModel: MutableList<InsectAdapterItemType>)
    : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemPosition == newItemPosition
    }

    override fun getOldListSize() = oldInsectAdapterItemTypeViewModel.size

    override fun getNewListSize() = newInsectAdapterItemTypeViewModel.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldInsectAdapterItemTypeViewModel[oldItemPosition] ==
                newInsectAdapterItemTypeViewModel[newItemPosition]
    }
}