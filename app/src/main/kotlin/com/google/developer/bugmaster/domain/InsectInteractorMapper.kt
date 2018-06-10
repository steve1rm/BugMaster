package com.google.developer.bugmaster.domain

import android.database.Cursor
import com.google.developer.bugmaster.data.models.InsectDataModel

interface InsectInteractorMapper<T> {
    fun map(insectTypesEntity: T): InsectDataModel
    fun map(cursor: Cursor): List<InsectDataModel>
}