package com.example.buynow.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Product Table")
data class ProductListItem(
    val category: String,
    val description: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)