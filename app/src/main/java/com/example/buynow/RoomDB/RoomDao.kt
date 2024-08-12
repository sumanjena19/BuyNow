package com.example.buynow.RoomDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.buynow.Model.ProductListItem

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(productList : List<ProductListItem>)

    @Query("select * from `Product Table`")
    fun get(): LiveData<List<ProductListItem>>
}