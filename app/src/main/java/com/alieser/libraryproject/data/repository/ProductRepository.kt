package com.alieser.libraryproject.data.repository

import androidx.lifecycle.MutableLiveData
import com.alieser.libraryproject.data.datasource.ProductDataSource
import com.alieser.libraryproject.data.model.Product
import javax.inject.Inject


// var productDataSource: ProductDataSource
class ProductRepository @Inject constructor(var productDataSource: ProductDataSource) {

    fun loadProducts() : MutableLiveData<List<Product>> = productDataSource.loadProducts()

    fun searchProduct(searchWord : String) : MutableLiveData<List<Product>> = productDataSource.searchProduct(searchWord)
}