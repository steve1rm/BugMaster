package com.google.developer.bugmaster.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.developer.bugmaster.R
import com.google.developer.bugmaster.data.models.InsectDataModel
import com.google.developer.bugmaster.presentation.screens.InsectItemSelectedListener

class InsectAdapter(private val insectList: MutableList<InsectDataModel>,
                    private val insectItemSelectedListener: InsectItemSelectedListener)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        val inflater = LayoutInflater.from(parent.context)

        return when(viewType) {
            InsectItemType.DESCRIPTION.type -> {
                view = inflater.inflate(R.layout.insect_row_item, parent, false)
                CustomInsectViewHolder(view)
            }

            InsectItemType.IMAGE.type -> {
                view = inflater.inflate(R.layout.bug_image_item, parent, false)
                CustomBugImageViewHolder(view)
            }

            else -> {
                    view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                CustomInsectViewHolder(view)
                }
            }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType) {
            InsectItemType.DESCRIPTION.type -> {
                if(holder is CustomInsectViewHolder) {
                    holder.tvFriendlyName.text = insectList[position].friendlyName
                    holder.tvScientificName.text = insectList [position].scientificName
                    holder.ivDangerLevel.setDangerLevel (insectList[position].dangerLevel)

                    holder.container.setOnClickListener {
                        insectItemSelectedListener.onInsectItemSelected(insectList[position])
                    }
                }
            }

            InsectItemType.IMAGE.type -> {
                if(holder is CustomBugImageViewHolder) {
                    holder.ivBugImage.setImageResource(R.drawable.ladybug)

                    holder.ivBugImage.setOnClickListener {
                        insectItemSelectedListener.onInsectItemSelected(insectList[position])
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return insectList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            insectList[position].itemType == InsectItemType.IMAGE.type -> InsectItemType.IMAGE.type
            insectList[position].itemType == InsectItemType.DESCRIPTION.type -> InsectItemType.DESCRIPTION.type
            else -> InsectItemType.UNKNOWN.type
        }
    }
}
