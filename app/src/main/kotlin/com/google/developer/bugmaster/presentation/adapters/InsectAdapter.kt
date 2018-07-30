package com.google.developer.bugmaster.presentation.adapters

import com.google.developer.bugmaster.presentation.core.BaseDelegateAdapter
import com.google.developer.bugmaster.presentation.core.ItemDelegate

class InsectAdapter(insectBugImageDelegate: ItemDelegate<CustomBugImageViewHolder, InsectAdapterItemType.InsectImage>,
                    insectDescriptionDelegate: ItemDelegate<CustomInsectViewHolder, InsectAdapterItemType.InsectDescription>)
    : BaseDelegateAdapter<InsectAdapterItemType>(
        insectBugImageDelegate,
        insectDescriptionDelegate) {

    fun populateData(list: MutableList<InsectAdapterItemType>) {
        items = list
        notifyDataSetChanged()

//        val list: List<InsectAdapterItemType> = ArrayList()
//        val insectDiffUtil: BaseDiffUtil<InsectAdapterItemType> = InsectDiffUtil()
 //       val oldItems = items
/*
        DiffUtil.calculateDiff(insectDiffUtil.callback(oldItems, list))
                .dispatchUpdatesTo(this)
*/

       /* open fun applyData(list: List<PropertyDetailsItem>) {
            val diffResult = DiffUtil.calculateDiff(propertyInfoDiffUtil.callback(items, list))
            items = list
            diffResult.dispatchUpdatesTo(this)
        }
        */
    }
}

