package com.google.developer.bugmaster.presentation.core

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import org.jetbrains.annotations.NotNull

interface AdapterDelegate<T, VH: RecyclerView.ViewHolder> {
    fun isForViewType(@NotNull items: T, position: Int): Boolean

    @NotNull
    fun onCreateViewHolder(parent: ViewGroup): VH

    fun onBindViewHolder(@NotNull items: T, position: Int, @NotNull viewHolder: VH)
}

