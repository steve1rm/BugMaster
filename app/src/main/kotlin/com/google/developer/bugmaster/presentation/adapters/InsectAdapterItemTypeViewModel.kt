package com.google.developer.bugmaster.presentation.adapters

import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
data class InsectAdapterItemTypeViewModel @ParcelConstructor constructor(
        val items: MutableList<InsectAdapterItemType>
)
