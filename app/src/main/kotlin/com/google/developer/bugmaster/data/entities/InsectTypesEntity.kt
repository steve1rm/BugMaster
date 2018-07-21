package com.google.developer.bugmaster.data.entities

import com.google.gson.annotations.SerializedName

data class InsectTypesEntity(
        @SerializedName("friendlyName") val friendlyName: String,
        @SerializedName("scientificName") val scientificName: String,
        @SerializedName("classification") val classification: String,
        @SerializedName("imageAsset") val imageAsset: String,
        @SerializedName("dangerLevel") val dangerLevel: Int,
        @SerializedName("itemType") val itemType: Int)
