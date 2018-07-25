package com.google.developer.bugmaster.presentation.core

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.ViewParent

abstract class BaseDelegateAdapter<I : Any>(vararg delegates: ItemDelegate<*, out I>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<I> = emptyList()

    private val itemTypeToDelegateIndexMap: Map<Class<*>, Int>
    private val delegateList: List<ItemDelegate<RecyclerView.ViewHolder, I>>

    init {
        val map = mutableMapOf<Class<*>, Int>()
        delegates.forEachIndexed { index, itemDelegate ->
            if (map.put(itemDelegate.itemType(), index) != null) {
                throw IllegalArgumentException("Difference delegates cannot work with the same item type")
            }
        }

        itemTypeToDelegateIndexMap = map
        delegateList = delegates.map {
            it as? ItemDelegate<RecyclerView.ViewHolder, I>
                    ?: throw IllegalArgumentException("Delegate should implement ItemDelegate interface")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateList[viewType].createViewHolder(parent)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        val itemType = item.javaClass
        val delegate = itemTypeToDelegateIndexMap[itemType]?.let { delegateList[it] }
                ?: throw IllegalArgumentException("The delegate is absent for this kind of item type: $itemType")

        delegate.bindViewHolder(viewHolder, item)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int) =
            itemTypeToDelegateIndexMap[items[position].javaClass] ?: throw IllegalArgumentException()
}

