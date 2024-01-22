package com.alieser.libraryproject.ui.viewmodel.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alieser.libraryproject.data.model.Product
import com.alieser.libraryproject.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// var productRepository: ProductRepository
@HiltViewModel
class ProductFragmentViewModel @Inject constructor (var productRepository: ProductRepository) : ViewModel() {

    var productList = MutableLiveData<List<Product>>()


    init {
        loadProducts()
    }

    fun loadProducts() {

        productList = productRepository.loadProducts()
    }

   fun searchProduct(searchWord : String) {

       productList = productRepository.searchProduct(searchWord)
   }

}