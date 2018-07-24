package com.google.developer.bugmaster.presentation.adapters

import org.parceler.Parcel
import org.parceler.ParcelConstructor

sealed class InsectAdapterItemType {

    @Parcel(Parcel.Serialization.BEAN)
data class InsectImage @ParcelConstructor constructor(

    )


}