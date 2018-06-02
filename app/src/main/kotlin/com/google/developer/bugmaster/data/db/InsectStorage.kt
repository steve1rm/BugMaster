package com.google.developer.bugmaster.data.db

import android.database.Cursor

interface InsectStorage<InsectDataModel> {
    fun insertInsect(insect: InsectDataModel)
    fun queryAndSort(sortOrder: String): Cursor
    fun queryOnId(id: Int): Cursor
    fun deleteTable()
}
