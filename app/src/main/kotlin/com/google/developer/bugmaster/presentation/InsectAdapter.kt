package com.google.developer.bugmaster.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.google.developer.bugmaster.R
import com.google.developer.bugmaster.data.Insect
import com.google.developer.bugmaster.data.InsectRecyclerAdapter
import android.widget.TextView





class InsectAdapter: InsectRecyclerAdapter() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsectHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.insect_row_item, parent, false)
        return InsectHolder(view)
    }

    override fun onBindViewHolder(holder: InsectHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun getItem(position: Int): Insect? {
        return null
    }

    class CustomInsectHolder:  InsectRecyclerAdapter.InsectHolder() {
        var ivDangerLevel: ImageView
        var tvFriendlyName: TextView
        var tvScientificName: TextView



    }
}