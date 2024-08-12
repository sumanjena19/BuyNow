package com.example.buynow

import android.app.Application
import com.example.buynow.DI.ApplicationComponent
import com.example.buynow.DI.DaggerApplicationComponent

class BuyNowApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent= DaggerApplicationComponent.factory().createInstance(this)
    }
}