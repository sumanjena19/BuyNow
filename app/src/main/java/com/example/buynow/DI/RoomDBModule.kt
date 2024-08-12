package com.example.buynow.DI

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.buynow.RoomDB.MyDatabase
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import jakarta.inject.Singleton

@Module
class RoomDBModule {

    @Singleton
    @Provides
    fun getRoomDBInstance(context : Context) : MyDatabase{
        return Room.databaseBuilder(context,MyDatabase::class.java,"Product DataBase").build()
    }
}