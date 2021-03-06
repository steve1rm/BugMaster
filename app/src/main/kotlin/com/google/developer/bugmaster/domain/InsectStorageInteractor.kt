package com.google.developer.bugmaster.domain

import android.database.Cursor
import io.reactivex.Completable
import io.reactivex.Single

interface InsectStorageInteractor<InsectEntity> {
    fun saveInsectToDatabase(insectEntity: InsectEntity): Completable

    fun getAllSortedInsects(sortOrder: String): Single<Cursor>

    fun getInsectOnID(id: Int): Single<Cursor>

    fun clearInsectsTable(): Completable
}

