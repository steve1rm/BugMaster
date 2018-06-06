package com.google.developer.bugmaster.domain

import android.database.Cursor
import com.google.developer.bugmaster.data.models.InsectDataModel

interface InsectInteractorMapper<InsectTypesEntity> {
    fun map(insectTypesEntity: InsectTypesEntity): InsectDataModel
    fun map(cursor: Cursor): List<InsectDataModel>
}