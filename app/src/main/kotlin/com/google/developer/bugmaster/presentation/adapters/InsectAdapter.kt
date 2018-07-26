package com.google.developer.bugmaster.presentation.adapters



import android.support.v7.util.DiffUtil
import com.google.developer.bugmaster.data.models.InsectDataModel
import com.google.developer.bugmaster.presentation.core.BaseDelegateAdapter
import com.google.developer.bugmaster.presentation.core.ItemDelegate

class InsectAdapter(insectBugImageDelegate: ItemDelegate<CustomBugImageViewHolder, InsectAdapterItemType.InsectImage>,
                    insectDescriptionDelegate: ItemDelegate<CustomInsectViewHolder, InsectAdapterItemType.InsectDescription>,
                    private val insectList: MutableList<InsectDataModel>)
    : BaseDelegateAdapter<InsectAdapterItemType>(
        insectBugImageDelegate,
        insectDescriptionDelegate) {

    fun populateData() {
        val list: List<InsectAdapterItemType> = ArrayList()
//        val insectDiffUtil: BaseDiffUtil<InsectAdapterItemType> = InsectDiffUtil()
        val oldItems = items
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

