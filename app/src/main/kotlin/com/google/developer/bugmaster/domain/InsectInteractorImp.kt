package com.google.developer.bugmaster.domain

import com.google.developer.bugmaster.data.models.InsectDataModel
import com.google.developer.bugmaster.data.entities.InsectTypesEntity

class InsectInteractorImp: InsectInteractor<InsectTypesEntity> {
    override fun map(insectTypesEntity: InsectTypesEntity): InsectDataModel {

        return InsectDataModel(
                insectTypesEntity.friendlyName,
                insectTypesEntity.scientificName,
                insectTypesEntity.classification,
                insectTypesEntity.imageAsset,
                insectTypesEntity.dangerLevel)
    }
}
