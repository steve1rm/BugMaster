package com.google.developer.bugmaster.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.developer.bugmaster.R
import com.google.developer.bugmaster.views.DangerLevelView

class CustomInsectHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ivDangerLevel: DangerLevelView = itemView.findViewById(R.id.ivDangerLevel)
    val tvFriendlyName: TextView = itemView.findViewById(R.id.tvFriendlyName)
    val tvScientificName: TextView = itemView.findViewById(R.id.tvScientificName)
    val container: ConstraintLayout = itemView.findViewById(R.id.layout_insect_row_item)
}
