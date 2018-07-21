package com.google.developer.bugmaster.data.models

import android.content.ContentValues
import com.google.developer.bugmaster.data.db.InsectContract
import com.google.developer.bugmaster.presentation.AdapterConstants
import com.google.developer.bugmaster.presentation.ViewType
import org.parceler.Parcel

@Parcel
data class InsectDataModel(var friendlyName: String = "",
                           var scientificName: String = "",
                           var classification: String = "",
                           var imageAsset: String = "",
                           var dangerLevel: Int = 0,
                           var itemType: Int = -1) {

    fun toContentValues(): ContentValues {
        return ContentValues().apply {
            put(InsectContract.COLUMN_FRIENDLY_NAME, friendlyName)
            put(InsectContract.COLUMN_SCIENTIFIC_NAME, scientificName)
            put(InsectContract.COLUMN_CLASSIFICATION, classification)
            put(InsectContract.COLUMN_IMAGE_ASSERT, imageAsset)
            put(InsectContract.COLUMN_DANGER_LEVEL, dangerLevel)
            put(InsectContract.COLUMN_ITEM_TYPE, itemType)
        }
    }

    override fun getViewType() = AdapterConstants.INSECTS.ordinal
}
