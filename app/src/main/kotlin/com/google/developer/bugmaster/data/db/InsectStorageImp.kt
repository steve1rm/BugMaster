package com.google.developer.bugmaster.data.db

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.google.developer.bugmaster.domain.InsectInteractorImp
import com.google.developer.bugmaster.entities.InsectEntity


class InsectStorageImp(private val db: SQLiteDatabase): InsectStorage<InsectEntity> {
    override fun insertInsect(insectEntity: InsectEntity) {
        val insectInteractor = InsectInteractorImp()

        insectEntity.insectTypesEntity.forEach {
            val insectDataModel = insectInteractor.map(it)
            db.insert(InsectContract.TABLE_NAME, null, insectDataModel.toContentValues())
            println(insectDataModel.friendlyName)
        }
    }

    override fun queryAndSort(sortOrder: String): Cursor? {
        return db.query(
                InsectContract.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null)
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

    override fun deleteTable() {
        db.delete(InsectContract.TABLE_NAME, null, null)
    }
}
