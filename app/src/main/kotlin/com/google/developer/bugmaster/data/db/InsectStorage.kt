package com.google.developer.bugmaster.data.db

import android.database.Cursor

interface InsectStorage<InsectEntity> {
    fun insertInsect(insectEntity: InsectEntity)
    fun queryAndSort(sortOrder: String): Cursor?
    fun queryOnId(id: Int): Cursor
    fun deleteTable()
}
