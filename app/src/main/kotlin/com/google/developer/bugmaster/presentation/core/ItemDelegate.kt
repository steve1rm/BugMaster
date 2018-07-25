package com.google.developer.bugmaster.presentation.core

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

interface ItemDelegate<VH : RecyclerView.ViewHolder, I> {
    fun itemType(): Class<out I>

    fun createViewHolder(parent: ViewGroup): VH

    fun bindViewHolder(viewHolder: VH, item: I)
}