package com.google.developer.bugmaster.domain

import com.google.developer.bugmaster.data.db.InsertStorageImp
import com.google.developer.bugmaster.data.models.InsectDataModel
import io.reactivex.Completable

class InsectStorageInteractorImp(private val insectStorageImp: InsertStorageImp)
    : InsectStorageInteractor<InsectDataModel> {

    override fun saveInsectToDatabase(insect: InsectDataModel): Completable {
        return Completable.fromCallable {
            insectStorageImp.insertInsect(insect)
        }
    }
}
