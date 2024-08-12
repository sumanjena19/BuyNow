package com.example.buynow.RoomDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.buynow.Model.ProductListItem

@Database(entities = [ProductListItem::class], version = 1)
abstract class MyDatabase : RoomDatabase(){
    abstract fun getDao():RoomDao
}