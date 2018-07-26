package com.google.developer.bugmaster.presentation.adapters

import android.os.Parcel
import org.parceler.ParcelConverter
import org.parceler.Parcels

class InsectAdapterItemTypeParcelConverter : ParcelConverter<InsectAdapterItemType> {
    override fun fromParcel(parcel: Parcel?): InsectAdapterItemType =
            Parcels.unwrap(parcel?.readParcelable(InsectAdapterItemType::class.java.classLoader))

    override fun toParcel(input: InsectAdapterItemType?, parcel: Parcel?) {
        val out = parcel ?: return
        val obj = input ?: return

        out.writeParcelable(Parcels.wrap(obj), 0)
    }
}
