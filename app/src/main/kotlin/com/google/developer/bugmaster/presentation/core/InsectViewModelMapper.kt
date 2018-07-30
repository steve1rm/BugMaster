package com.google.developer.bugmaster.presentation.core

import com.google.developer.bugmaster.data.models.InsectDataModel
import com.google.developer.bugmaster.presentation.adapters.InsectAdapterItemType
import com.google.developer.bugmaster.presentation.adapters.InsectAdapterItemTypeViewModel
import com.google.developer.bugmaster.presentation.adapters.InsectItemType

class InsectViewModelMapper: Mapper<MutableList<InsectDataModel>, InsectAdapterItemTypeViewModel> {
    override fun map(item: MutableList<InsectDataModel>): InsectAdapterItemTypeViewModel {
        val insectAdapterItemTypeItems = mutableListOf<InsectAdapterItemType>()
        var counter = 0

        item.forEach {
            if(it.itemType == InsectItemType.IMAGE.type) {
                insectAdapterItemTypeItems.add(counter, InsectAdapterItemType.InsectImage(item[counter].imageAsset))
            }
            else {
                insectAdapterItemTypeItems.add(counter, InsectAdapterItemType.InsectDescription(item[counter]))
            }

            counter++
        }

        return InsectAdapterItemTypeViewModel(insectAdapterItemTypeItems)
    }
}