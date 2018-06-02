package com.google.developer.bugmaster

import android.app.Application
import com.facebook.stetho.Stetho
import com.google.developer.bugmaster.data.BugsDbHelper

class BugMasterApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

        val bugsDbHelper = BugsDbHelper(this)
        bugsDbHelper.readInsectsFromResources(bugsDbHelper.readableDatabase)
    }
}
