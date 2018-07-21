package com.google.developer.bugmaster.presentation

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.developer.bugmaster.R
import com.google.developer.bugmaster.data.models.InsectDataModel
import com.google.developer.bugmaster.presentation.screens.InsectItemSelectedListener
import com.google.developer.bugmaster.views.DangerLevelView

class InsectAdapter(private val insectList: MutableList<InsectDataModel>,
                    private val insectItemSelectedListener: InsectItemSelectedListener)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class ItemType(val type: Int) {
        ITEM(1),
        IMAGE(2),
        UNKNOWN(3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        val inflater = LayoutInflater.from(parent.context)

        return when(viewType) {
            ItemType.ITEM.type -> {
                view = inflater.inflate(R.layout.insect_row_item, parent, false)
                CustomInsectHolder(view)
            }

            ItemType.IMAGE.type -> {
                view = inflater.inflate(R.layout.bug_image_item, parent, false)
                CustomBugImageHolder(view)
            }

            else -> {
                    view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                    CustomInsectHolder(view)
                }
            }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType) {
            ItemType.ITEM.type -> {
                if(holder is CustomInsectHolder) {
                    holder.tvFriendlyName.text = insectList[position].friendlyName
                    holder.tvScientificName.text = insectList [position].scientificName
                    holder.ivDangerLevel.setDangerLevel (insectList[position].dangerLevel)

                    holder.container.setOnClickListener {
                        insectItemSelectedListener.onInsectItemSelected(insectList[position])
                    }
                }
            }

            ItemType.IMAGE.type -> {
                if(holder is CustomBugImageHolder) {
                    holder.ivBugimage.setImageResource(R.drawable.ladybug)

                    holder.ivBugimage.setOnClickListener {
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
            insectList[position].itemType == ItemType.IMAGE.type -> ItemType.IMAGE.type
            insectList[position].itemType == ItemType.ITEM.type -> ItemType.ITEM.type
            else -> ItemType.UNKNOWN.type
        }
    }

    class CustomInsectHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivDangerLevel: DangerLevelView = itemView.findViewById(R.id.ivDangerLevel)
        val tvFriendlyName: TextView = itemView.findViewById(R.id.tvFriendlyName)
        val tvScientificName: TextView = itemView.findViewById(R.id.tvScientificName)
        val container: ConstraintLayout = itemView.findViewById(R.id.layout_insect_row_item)
    }

    class CustomBugImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivBugimage: ImageView = itemView.findViewById(R.id.ivBugImage)
    }
}
