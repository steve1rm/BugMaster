package com.google.developer.bugmaster.data.db

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.google.developer.bugmaster.data.models.InsectDataModel

class InsectStorageImp(private val db: SQLiteDatabase): InsectStorage<InsectDataModel> {
    override fun insertInsect(insect: InsectDataModel) {
        db.insertOrThrow(InsectContract.TABLE_NAME, null, insect.toContentValues())
    }

    override fun queryAndSort(sortOrder: String): Cursor {
        return db.query(
                InsectContract.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                sortOrder)
    }

    override fun queryOnId(id: Int): Cursor {
        val whereEqualToRowId = "rowId = ?"
        return db.query(
                InsectContract.TABLE_NAME,
                null,
                whereEqualToRowId,
                arrayOf(id.toString()),
                null,
                null,
                null)
    }
}
