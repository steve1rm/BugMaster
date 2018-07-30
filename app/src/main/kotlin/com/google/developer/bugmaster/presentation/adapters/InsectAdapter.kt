package com.google.developer.bugmaster.presentation.adapters

import android.support.v7.util.DiffUtil
import com.google.developer.bugmaster.presentation.core.BaseDelegateAdapter
import com.google.developer.bugmaster.presentation.core.InsectDiffCallback
import com.google.developer.bugmaster.presentation.core.ItemDelegate

class InsectAdapter(insectBugImageDelegate: ItemDelegate<CustomBugImageViewHolder, InsectAdapterItemType.InsectImage>,
                    insectDescriptionDelegate: ItemDelegate<CustomInsectViewHolder, InsectAdapterItemType.InsectDescription>)
    : BaseDelegateAdapter<InsectAdapterItemType>(
        insectBugImageDelegate,
        insectDescriptionDelegate) {

    fun populateData(list: MutableList<InsectAdapterItemType>) {
        val diffCallback = InsectDiffCallback(items.toMutableList(), list)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items = list
        diffResult.dispatchUpdatesTo(this)
    }
}

