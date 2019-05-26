package com.nikolaypuliaiev.recycling

import android.app.Application
import io.realm.Realm

class RecyclingApp: Application() {

    companion object {
        lateinit var appContext: RecyclingApp
    }

    override fun onCreate() {
        super.onCreate()

        appContext = this

        Realm.init(this)
    }

}