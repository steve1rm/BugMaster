package com.google.developer.bugmaster.presentation.core

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import org.jetbrains.annotations.NotNull

class AdapterDelegateManager<T> {
    fun <T> addDelegate(@NotNull adapterDelegate: AdapterDelegate<T>) {

    }

    fun <T> getItemViewType(@NotNull items: T, position: Int) {

    }

/*
    @NotNull
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }
*/

    fun onBindViewHolder(@NotNull items: T, position: Int, @NotNull viewHolder: RecyclerView.ViewHolder) {

    }
}