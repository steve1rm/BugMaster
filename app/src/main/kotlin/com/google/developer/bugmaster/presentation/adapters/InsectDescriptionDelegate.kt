package com.google.developer.bugmaster.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.developer.bugmaster.R
import com.google.developer.bugmaster.data.models.InsectDataModel

class InsectDescriptionDelegate(private var viewType: Int) {

    fun getViewType() = viewType

    fun isForViewType(items: MutableList<InsectDataModel>, position: Int): Boolean {
        return items[position].itemType == InsectItemType.DESCRIPTION.type
    }

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater =  LayoutInflater.from(parent.context)
        return CustomInsectHolder(inflater.inflate(R.layout.insect_row_item, parent, false))
    }

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, insectList: MutableList<InsectDataModel>) {
        if(holder is CustomInsectHolder) {
            holder.tvFriendlyName.text = insectList[position].friendlyName
            holder.tvScientificName.text = insectList [position].scientificName
            holder.ivDangerLevel.setDangerLevel (insectList[position].dangerLevel)

            holder.container.setOnClickListener {
         //       insectItemSelectedListener.onInsectItemSelected(insectList[position])
            }
        }
    }
}
