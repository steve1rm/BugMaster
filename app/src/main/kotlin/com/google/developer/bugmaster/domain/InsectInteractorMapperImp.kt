package com.google.developer.bugmaster.domain

import android.database.Cursor
import com.google.developer.bugmaster.data.db.InsectContract
import com.google.developer.bugmaster.data.entities.InsectTypesEntity
import com.google.developer.bugmaster.data.models.InsectDataModel

class InsectInteractorMapperImp: InsectInteractorMapper<InsectTypesEntity, InsectDataModel> {
    override fun map(insectTypesEntity: InsectTypesEntity): InsectDataModel {

        return InsectDataModel(
                insectTypesEntity.friendlyName,
                insectTypesEntity.scientificName,
                insectTypesEntity.classification,
                insectTypesEntity.imageAsset,
                insectTypesEntity.dangerLevel)
    }

    override fun map(cursor: Cursor): List<InsectDataModel> {
        val insectDataModelList: MutableList<InsectDataModel> = mutableListOf()

        cursor.moveToFirst()
        while(cursor.moveToNext()) {
            InsectDataModel().let {
                it.friendlyName = cursor.getString(cursor.getColumnIndexOrThrow(InsectContract.COLUMN_FRIENDLY_NAME))
                it.scientificName = cursor.getString(cursor.getColumnIndexOrThrow(InsectContract.COLUMN_SCIENTIFIC_NAME))
                it.dangerLevel = cursor.getInt(cursor.getColumnIndexOrThrow(InsectContract.COLUMN_DANGER_LEVEL))
                it.classification = cursor.getString(cursor.getColumnIndexOrThrow(InsectContract.COLUMN_CLASSIFICATION))
                it.imageAsset = cursor.getString(cursor.getColumnIndexOrThrow(InsectContract.COLUMN_IMAGE_ASSERT))

                insectDataModelList.add(it)
            }
        }

        cursor.close()
        return insectDataModelList.toList()
    }
}
