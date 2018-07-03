package com.google.developer.bugmaster.presentation.screens

import com.google.developer.bugmaster.data.models.InsectDataModel

interface InsectItemSelectedListener {
    fun onInsectItemSelected(insectDataModel: InsectDataModel)
}
