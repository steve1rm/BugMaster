package com.google.developer.bugmaster.presentation.screens

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.common.collect.ImmutableList
import com.google.developer.bugmaster.R
import com.google.developer.bugmaster.data.models.InsectDataModel
import com.google.developer.bugmaster.presentation.*
import com.google.developer.bugmaster.views.DangerLevelView

class InsectAdapter(private val insectList: MutableList<InsectDataModel>,
                            private val insectItemSelectedListener: InsectItemSelectedListener)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ImmutableList<ViewType> = ImmutableList.of()
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING.ordinal
    }

    init {
        delegateAdapters.put(AdapterConstants.LOADING.ordinal, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.INSECTS.ordinal, InsectDelegateAdapter(insectItemSelectedListener))
        items.add(loadingItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType).onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position))
                .onBindViewHolder(holder, items[position])
    }

    override fun getItemViewType(position: Int): Int {
        items[position].getViewType()
    }

    override fun getItemCount(): Int {
        return insectList.size
    }
}
