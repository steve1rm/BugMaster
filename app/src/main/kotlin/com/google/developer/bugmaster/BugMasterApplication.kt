package com.google.developer.bugmaster

import android.app.Application
import com.facebook.stetho.Stetho

class BugMasterApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}
