package com.google.developer.bugmaster.data.db

import android.database.Cursor

interface InsectStorage<T> {
    fun insertInsect(insectEntity: T)
    fun queryAndSort(sortOrder: String): Cursor?
    fun queryOnId(id: Int): Cursor
    fun deleteTable()
}
