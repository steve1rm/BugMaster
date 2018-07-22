package com.google.developer.bugmaster.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.developer.bugmaster.R
import com.google.developer.bugmaster.data.models.InsectDataModel
import com.google.developer.bugmaster.presentation.core.AdapterDelegate

class InsectDescriptionDelegate(private var viewType: Int) : AdapterDelegate<MutableList<InsectDataModel>> {

    fun getViewType() = viewType

    override fun isForViewType(items: MutableList<InsectDataModel>, position: Int): Boolean {
        return items[position].itemType == InsectItemType.DESCRIPTION.type
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater =  LayoutInflater.from(parent.context)
        return CustomInsectHolder(inflater.inflate(R.layout.insect_row_item, parent, false))
    }

    override fun onBindViewHolder(items: MutableList<InsectDataModel>, position: Int, viewHolder: RecyclerView.ViewHolder) {
        if(viewHolder is CustomInsectHolder) {
            viewHolder.tvFriendlyName.text = items[position].friendlyName
            viewHolder.tvScientificName.text = items [position].scientificName
            viewHolder.ivDangerLevel.setDangerLevel (items[position].dangerLevel)

            viewHolder.container.setOnClickListener {
         //       insectItemSelectedListener.onInsectItemSelected(items[position])
            }
        }
    }
}
