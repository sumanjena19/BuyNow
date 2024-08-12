package com.example.buynow.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.buynow.Repository.ProductRepository
import jakarta.inject.Inject

class MainActivityViewModelFactory @Inject constructor(private val map : Map<Class<*>, @JvmSuppressWildcards ViewModel>) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return  map[modelClass] as T
    }
}