package com.google.developer.bugmaster.data.models

import android.content.ContentValues
import com.google.developer.bugmaster.data.db.InsectContract

data class InsectDataModel(val friendlyName: String,
                           val scientificName: String,
                           val classification: String,
                           val imageAsset: String,
                           val dangerLevel: Int) {

    fun toContentValues(): ContentValues {
        return ContentValues().apply {
            put(InsectContract.COLUMN_FRIENDLY_NAME, friendlyName)
            put(InsectContract.COLUMN_SCIENTIFIC_NAME, scientificName)
            put(InsectContract.COLUMN_CLASSIFICATION, classification)
            put(InsectContract.COLUMN_IMAGE_ASSERT, imageAsset)
            put(InsectContract.COLUMN_DANGER_LEVEL, dangerLevel)
        }
    }
}