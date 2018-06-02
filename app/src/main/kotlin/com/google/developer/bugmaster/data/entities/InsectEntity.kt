package com.google.developer.bugmaster.data.entities

import com.google.gson.annotations.SerializedName

data class InsectEntity(
        @SerializedName("insects") val insectTypesEntity: ArrayList<InsectTypesEntity>)
