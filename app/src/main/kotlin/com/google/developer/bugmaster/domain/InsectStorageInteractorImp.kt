package com.google.developer.bugmaster.domain

import android.database.Cursor
import com.google.developer.bugmaster.data.db.InsectStorageImp
import com.google.developer.bugmaster.data.entities.InsectEntity
import io.reactivex.Completable
import io.reactivex.Single

class InsectStorageInteractorImp(private val insectStorageImp: InsectStorageImp)
    : InsectStorageInteractor<InsectEntity> {

    override fun saveInsectToDatabase(insectEntity: InsectEntity): Completable {
        return Completable.fromCallable {
            insectStorageImp.insertInsect(insectEntity)
        }
    }

    override fun getAllSortedInsects(sortOrder: String): Single<Cursor> {
        return Single.fromCallable {
            insectStorageImp.queryAndSort(sortOrder)
        }
    }

    override fun getInsectOnID(id: Int): Single<Cursor> {
        return Single.fromCallable {
            insectStorageImp.queryOnId(id)
        }
    }

    override fun clearInsectsTable(): Completable {
        return Completable.fromCallable {
            insectStorageImp.deleteTable()
        }
    }
}
