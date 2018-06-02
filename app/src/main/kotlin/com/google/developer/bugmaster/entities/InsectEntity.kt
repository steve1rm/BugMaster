package com.google.developer.bugmaster.entities

import com.google.gson.annotations.SerializedName

data class InsectEntity(
        @SerializedName("insects") val insectTypesEntity: ArrayList<InsectTypesEntity>)
