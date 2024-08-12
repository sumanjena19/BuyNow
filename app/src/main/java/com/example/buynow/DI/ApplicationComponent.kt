package com.example.buynow.DI

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.buynow.MainActivity
import dagger.BindsInstance
import dagger.Component
import jakarta.inject.Singleton

/*
   When there is scoped object in the component then it should be also marked as singleton
 */
@Singleton
@Component(modules = [NetworkModule::class,RoomDBModule::class,ViewModelModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    fun getMap() : Map<Class<*>, ViewModel>

    @Component.Factory
    interface Factory{
        fun createInstance(@BindsInstance context : Context) : ApplicationComponent
    }
}