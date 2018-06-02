package com.google.developer.bugmaster

import android.app.Application
import com.facebook.stetho.Stetho
import com.google.developer.bugmaster.data.BugsDbHelper
import com.google.developer.bugmaster.data.db.InsectStorageImp
import com.google.developer.bugmaster.domain.InsectStorageInteractorImp
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class BugMasterApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

        val bugsDbHelper = BugsDbHelper(this)

        val insectStorageInteractorImp = InsectStorageInteractorImp(
                InsectStorageImp(bugsDbHelper.writableDatabase))

        val disposable = insectStorageInteractorImp.
                clearInsectsTable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( {
                    bugsDbHelper.readInsectsFromResources(bugsDbHelper.readableDatabase)
                }, {
                    error -> println(error.message)
                })
    }
}
