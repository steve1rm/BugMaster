package com.google.developer.bugmaster.presentation

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.common.collect.ImmutableList
import com.google.developer.bugmaster.R
import com.google.developer.bugmaster.data.models.InsectDataModel
import java.util.Collections.addAll
import kotlin.properties.Delegates

class InsectAdapter(private var insectList: MutableList<InsectDataModel>): RecyclerView.Adapter<InsectAdapter.CustomInsectHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomInsectHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.insect_row_item, parent, false)

        return CustomInsectHolder(view)
    }

    override fun onBindViewHolder(holder: CustomInsectHolder, position: Int) {
        holder.tvFriendlyName.text = insectList[position].friendlyName
        holder.tvScientificName.text = insectList[position].scientificName
    }

    override fun getItemCount(): Int {
        return insectList.size
    }

    fun loadInsects(insectList: MutableList<InsectDataModel>) {
        println(insectList.javaClass)
        println(this.insectList.javaClass)

        insectList.forEach {
            this.insectList.add(it)
        }

        notifyDataSetChanged()
    }

    class CustomInsectHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
        val ivDangerLevel: ImageView = itemView.findViewById(R.id.ivDangerLevel)
        val tvFriendlyName: TextView = itemView.findViewById(R.id.tvFriendlyName)
        val tvScientificName: TextView = itemView.findViewById(R.id.tvScientificName)
    }
}
