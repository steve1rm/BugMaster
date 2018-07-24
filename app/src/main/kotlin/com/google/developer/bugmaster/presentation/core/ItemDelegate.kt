package com.google.developer.bugmaster.presentation.core

import android.view.ViewGroup

interface ItemDelegate<VH : RecyclerView.ViewHolder, I> {
    fun itemType(): Class<out T>

    fun createViewHolder(parent: ViewGroup): VH

    fun bindViewHolder(viewHolder: VH, item: I)
}