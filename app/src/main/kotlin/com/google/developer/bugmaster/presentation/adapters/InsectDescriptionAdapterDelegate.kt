package com.google.developer.bugmaster.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.developer.bugmaster.R
import com.google.developer.bugmaster.presentation.core.ItemDelegate

class InsectDescriptionAdapterDelegate : ItemDelegate<CustomInsectViewHolder, InsectAdapterItemType.InsectDescription> {

    override fun itemType(): Class<out InsectAdapterItemType.InsectDescription> {
        InsectAdapterItemType.InsectDescription::class.java
    }

    override fun createViewHolder(parent: ViewGroup): CustomInsectViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return CustomInsectViewHolder(inflater.inflate(R.layout.insect_row_item, parent, false))
    }

    override fun bindViewHolder(viewHolder: CustomInsectViewHolder, item: InsectAdapterItemType.InsectDescription) {
        viewHolder.tvFriendlyName.text = item.insectTypeDescription.friendlyName
        viewHolder.tvScientificName.text = item.insectTypeDescription.scientificName
        viewHolder.ivDangerLevel.setDangerLevel (item.insectTypeDescription.dangerLevel)
    }
}
