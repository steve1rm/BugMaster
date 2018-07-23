package com.google.developer.bugmaster.presentation.core

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

class AdapterDelegateManager<T> {
    private val delegates: SparseArrayCompat<AdapterDelegate<T, RecyclerView.ViewHolder>> = SparseArrayCompat()
    private var fallbackDelegate: AdapterDelegate<T, RecyclerView.ViewHolder>? = null

    fun addDelegate(@NotNull delegate: AdapterDelegate<T, RecyclerView.ViewHolder>): AdapterDelegateManager<T> {
        var viewType = delegates.size()

        while(delegates.get(viewType) != null) {
            viewType++
        }

        return addDelegate(viewType, false, delegate)
    }

    fun addDelegate(viewType: Int, @NotNull delegate: AdapterDelegate<T, RecyclerView.ViewHolder>): AdapterDelegateManager<T> {
        return addDelegate(viewType, false, delegate)
    }

    fun addDelegate(viewType: Int, allowReplacingDelegate: Boolean, @NotNull delegate: AdapterDelegate<T, RecyclerView.ViewHolder>): AdapterDelegateManager<T> {
        if(!allowReplacingDelegate && delegates[viewType] != null) {
            throw IllegalArgumentException("Already registered")
        }

        delegates.put(viewType, delegate)

        return this
    }

    fun getItemViewType(@NotNull items: T, position: Int): Int {
        if (items == null) {
            throw NullPointerException("Items datasource is null!")
        }

        val delegatesCount = delegates.size()
        for (i in 0 until delegatesCount) {
            val delegate = delegates.valueAt(i)
            if (delegate.isForViewType(items, position)) {
                return delegates.keyAt(i)
            }
        }

        throw NullPointerException(
                "No AdapterDelegate added that matches position=$position in data source")
    }

    @NotNull
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val delegate = getDelegateForViewType(viewType)
                ?: throw NullPointerException("No AdapterDelegate added for ViewType $viewType")

        return delegate.onCreateViewHolder(parent)
    }


    fun onBindViewHolder(@NotNull items: T, position: Int, @NotNull viewHolder: RecyclerView.ViewHolder) {
        val delegate = getDelegateForViewType(viewHolder.itemViewType)
                ?: throw NullPointerException("No delegate found for item at position = "
                        + position
                        + " for viewType = "
                        + viewHolder.itemViewType)

        delegate.onBindViewHolder(items, position, viewHolder)
    }

    @Nullable
    fun getDelegateForViewType(viewType: Int): AdapterDelegate<T, RecyclerView.ViewHolder> {
        return delegates.get(viewType, fallbackDelegate)
    }
}