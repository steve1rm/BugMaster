package com.google.developer.bugmaster.data.db

class InsectContract {
    companion object Insect {
        const val TABLE_NAME = "insects"
        const val COLUMN_INSECT_ID = "insect_id"
        const val COLUMN_FRIENDLY_NAME = "friendlyName"
        const val COLUMN_SCIENTIFIC_NAME = "scientificName"
        const val COLUMN_CLASSIFICATION = "classification"
        const val COLUMN_IMAGE_ASSERT = "imageAssert"
        const val COLUMN_DANGER_LEVEL = "dangerLevel"

        const val CREATE_STATEMENT = "CREATE TABLE $TABLE_NAME" +
                " (" +
                "$COLUMN_INSECT_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_FRIENDLY_NAME TEXT, " +
                "$COLUMN_SCIENTIFIC_NAME TEXT, " +
                "$COLUMN_CLASSIFICATION TEXT, " +
                "$COLUMN_IMAGE_ASSERT TEXT, " +
                "$COLUMN_DANGER_LEVEL INTEGER" +
                 ");"

        const val DELETE_STATEMENT = "DELETE FROM $TABLE_NAME"
        const val DROP_STATMENT = "DROP TABLE IF EXISTS $TABLE_NAME"
    }
}

