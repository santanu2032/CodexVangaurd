package com.Presentation.CommonUI.Event.Event_II

import android.app.Application

class MyApp : Application() {

    lateinit var container: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(AndroidPlatformDependencies(this))
    }
}