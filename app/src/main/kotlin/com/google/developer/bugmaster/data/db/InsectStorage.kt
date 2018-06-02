package com.google.developer.bugmaster.data.db

import android.database.Cursor
import com.google.developer.bugmaster.entities.InsectEntity

interface InsectStorage<InsectDataModel> {
    fun insertInsect(insectEntity: InsectEntity)
    fun queryAndSort(sortOrder: String): Cursor?
    fun queryOnId(id: Int): Cursor
    fun deleteTable()
}
