package com.example.buynow.DI

import com.example.buynow.Retrofit.RetrofitService
import com.example.buynow.utils.Constants
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import jakarta.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build();
    }

    @Singleton
    @Provides
    fun providesServiceInstance(retrofit: Retrofit) : RetrofitService{
        return retrofit.create(RetrofitService::class.java);
    }

}