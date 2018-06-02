package com.google.developer.bugmaster.domain

import com.google.developer.bugmaster.data.models.InsectDataModel

interface InsectInteractor<InsectTypesEntity> {
    fun map(insectTypesEntity: InsectTypesEntity): InsectDataModel
}