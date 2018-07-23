package com.google.developer.bugmaster.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.developer.bugmaster.R
import com.google.developer.bugmaster.data.models.InsectDataModel
import com.google.developer.bugmaster.presentation.core.AdapterDelegate
import com.google.developer.bugmaster.presentation.screens.InsectItemSelectedListener

class InsectDescriptionDelegate(private var viewType: Int,
                                private val insectItemSelectedListener: InsectItemSelectedListener)
    : AdapterDelegate<MutableList<InsectDataModel>, CustomInsectViewHolder> {

    fun getViewType() = viewType

    override fun isForViewType(items: MutableList<InsectDataModel>, position: Int)
            = items[position].itemType == InsectItemType.DESCRIPTION.type

    override fun onCreateViewHolder(parent: ViewGroup): CustomInsectViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return CustomInsectViewHolder(inflater.inflate(R.layout.insect_row_item, parent, false))
    }

    override fun onBindViewHolder(items: MutableList<InsectDataModel>, position: Int, viewHolder: CustomInsectViewHolder) {
        viewHolder.tvFriendlyName.text = items[position].friendlyName
        viewHolder.tvScientificName.text = items [position].scientificName
        viewHolder.ivDangerLevel.setDangerLevel (items[position].dangerLevel)

        viewHolder.container.setOnClickListener {
                   insectItemSelectedListener.onInsectItemSelected(items[position])
        }
    }
}
