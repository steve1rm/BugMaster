package com.google.developer.bugmaster.domain

import com.google.developer.bugmaster.entities.InsectTypesEntity
import com.google.gson.Gson

class InsectInteractor {
    fun map(jsonRaw: String) {
        val gson = Gson()
        val insectEntity = gson.fromJson<InsectTypesEntity>(jsonRaw, InsectTypesEntity::class.java)

    }
}