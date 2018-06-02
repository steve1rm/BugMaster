package com.google.developer.bugmaster.data.db

import android.database.sqlite.SQLiteDatabase
import com.google.developer.bugmaster.data.models.InsectDataModel

class InsectStorageImp(private val db: SQLiteDatabase): InsectStorage<InsectDataModel> {
    override fun insertInsect(insect: InsectDataModel) {
        db.insertOrThrow(InsectContract.TABLE_NAME, null, insect.toContentValues())
    }
}