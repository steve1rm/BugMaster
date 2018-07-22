package com.google.developer.bugmaster.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.google.developer.bugmaster.R


class CustomBugImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ivBugimage: ImageView = itemView.findViewById(R.id.ivBugImage)
}
