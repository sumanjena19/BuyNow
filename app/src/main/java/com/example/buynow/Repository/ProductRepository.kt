package com.example.buynow.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.RoomDatabase
import com.example.buynow.Model.ProductListItem
import com.example.buynow.Retrofit.RetrofitService
import com.example.buynow.RoomDB.MyDatabase
import jakarta.inject.Inject

class ProductRepository @Inject constructor(private val retrofitService: RetrofitService,private val roomDatabase: MyDatabase) {
     /*
        We create a mutable live data object to store and change our value but to prevent other
        classes to manipulate our data we expose a live data object to them
      */
     private val _productsList =MutableLiveData<List<ProductListItem>>()
     val productList : LiveData<List<ProductListItem>>
         get() = _productsList

     suspend fun getProductList(){
         val response =retrofitService.getProducts()
         if(response.isSuccessful && response.body() != null){
             _productsList.postValue(response.body())
//             roomDatabase.getDao().insert()
         }
     }

}