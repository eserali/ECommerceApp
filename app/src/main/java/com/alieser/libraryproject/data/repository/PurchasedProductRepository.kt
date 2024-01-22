package com.alieser.libraryproject.data.repository

import androidx.lifecycle.MutableLiveData
import com.alieser.libraryproject.data.datasource.PurchasedProductDataSoruce
import com.alieser.libraryproject.data.model.PurchasedProduct
import javax.inject.Inject

class PurchasedProductRepository @Inject constructor(var purchasedProductDataSoruce: PurchasedProductDataSoruce){

    fun loadPurchasedProducts() : MutableLiveData<List<PurchasedProduct>> = purchasedProductDataSoruce.loadPurchasedProducts()
}