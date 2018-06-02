package com.google.developer.bugmaster.data

import android.provider.BaseColumns

class InsertContract {
    companion object Insect {
        const val TABLE_NAME = "insects"
        const val COLUMN_NAME = "friendlyName"
        const val COLUMN_SCIENTIFIC_NAME = "scientificName"
        const val COLUMN_CLASSIFICATION = "classification"
        const val COLUMN_IMAGE_ASSERT = "imageAssert"
        const val COLUMN_DANGER_LEVEL = "dangerLevel"

        const val CREATE_STATEMENT = "CREATE TABLE $TABLE_NAME" +
                " (" +
                "${BaseColumns._ID} PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NAME TEXT NOT NULL, " +
                "$COLUMN_SCIENTIFIC_NAME TEXT NOT NULL, " +
                "$COLUMN_CLASSIFICATION TEXT NOT NULL, " +
                "$COLUMN_IMAGE_ASSERT TEXT NOT NULL, " +
                "$COLUMN_DANGER_LEVEL INTEGER" +
                 " );"

        const val DELETE_STATEMENT = "DELETE FROM $TABLE_NAME"
        const val DROP_STATMENT = "DROP TABLE IF EXISTS $TABLE_NAME"
    }
}

