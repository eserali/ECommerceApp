package com.alieser.libraryproject.data.repository

import androidx.lifecycle.MutableLiveData
import com.alieser.libraryproject.data.datasource.ProductBasketDataSource
import com.alieser.libraryproject.data.model.ProductBasket
import javax.inject.Inject

class ProductBasketRepository @Inject constructor(var productBasketDataSource: ProductBasketDataSource) {

    fun loadBasket() : MutableLiveData<List<ProductBasket>> = productBasketDataSource.loadBasket()

}