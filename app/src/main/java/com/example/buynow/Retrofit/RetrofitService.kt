package com.example.buynow.Retrofit

import com.example.buynow.Model.ProductListItem
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("products")
    suspend fun getProducts() : Response<List<ProductListItem>>
}