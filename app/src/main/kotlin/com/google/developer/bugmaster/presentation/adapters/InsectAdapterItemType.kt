package com.google.developer.bugmaster.presentation.adapters

import com.google.developer.bugmaster.data.models.InsectDataModel
import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(converter = InsectAdapterItemTypeParcelConverter::class)
sealed class InsectAdapterItemType {

    @Parcel(Parcel.Serialization.BEAN)
    data class InsectImage @ParcelConstructor constructor(
            val insectTypeImage: InsectDataModel): InsectAdapterItemType()

    @Parcel(Parcel.Serialization.BEAN)
    data class InsectDescription @ParcelConstructor constructor(
            val insectTypeDescription: InsectDataModel): InsectAdapterItemType()
}
