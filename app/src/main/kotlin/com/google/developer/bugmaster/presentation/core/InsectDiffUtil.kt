package com.google.developer.bugmaster.presentation.core

import com.google.developer.bugmaster.presentation.adapters.InsectAdapterItemType

class InsectDiffUtil : BaseDiffUtil<InsectAdapterItemType>() {
    override fun itemsTheSame(oldItem: InsectAdapterItemType, newItem: InsectAdapterItemType): Boolean {
        return oldItem::javaClass == newItem::javaClass
    }

    override fun contentsTheSame(oldItem: InsectAdapterItemType, newItem: InsectAdapterItemType): Boolean {
        return oldItem == newItem
    }
}
