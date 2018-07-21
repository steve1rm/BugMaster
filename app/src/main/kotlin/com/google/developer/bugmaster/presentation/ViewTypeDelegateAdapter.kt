package com.google.developer.bugmaster.presentation

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, item: ViewType)
}
