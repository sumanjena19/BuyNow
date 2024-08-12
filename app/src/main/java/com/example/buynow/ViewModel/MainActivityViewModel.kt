package com.example.buynow.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buynow.Model.ProductListItem
import com.example.buynow.Repository.ProductRepository
import jakarta.inject.Inject
import kotlinx.coroutines.launch

/*
   View Model class constructor can't be injected directly as we will create it using
   ViewModelFactory class.
 */
class MainActivityViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel() {

    val productList : LiveData<List<ProductListItem>>
        get()=repository.productList

    init {
        viewModelScope.launch{
            repository.getProductList()
        }
    }
}