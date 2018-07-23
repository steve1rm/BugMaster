package com.google.developer.bugmaster.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.google.developer.bugmaster.R

class CustomBugImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ivBugImage: ImageView = itemView.findViewById(R.id.ivBugImage)
}
