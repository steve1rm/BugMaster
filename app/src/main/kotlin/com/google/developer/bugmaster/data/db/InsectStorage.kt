package com.google.developer.bugmaster.data.db

interface InsectStorage<InsectDataModel> {
    fun insertInsect(insect: InsectDataModel)
}
