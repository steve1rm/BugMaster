package com.google.developer.bugmaster.domain

import io.reactivex.Completable

interface InsectStorageInteractor<InsectDataModel> {
    fun saveInsectToDatabase(insect: InsectDataModel): Completable
}
