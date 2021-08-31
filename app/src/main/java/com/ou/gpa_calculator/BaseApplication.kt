package com.ou.gpa_calculator

import android.app.Application
import android.content.Context
import timber.log.Timber

class BaseApplication : Application() {

    private lateinit var application: Context

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree());
        }

        application = getApplicationContext();
    }



}