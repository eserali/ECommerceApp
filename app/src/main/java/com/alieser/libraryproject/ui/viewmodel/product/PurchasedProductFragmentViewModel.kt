package com.alieser.libraryproject.ui.viewmodel.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alieser.libraryproject.data.model.PurchasedProduct
import com.alieser.libraryproject.data.repository.PurchasedProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel

class PurchasedProductFragmentViewModel @Inject constructor (var purchasedProductRepository: PurchasedProductRepository) : ViewModel() {

    var purchasedProductList = MutableLiveData<List<PurchasedProduct>>()

    init {
        loadPurchasedProducts()
    }
    fun loadPurchasedProducts() {
        purchasedProductList = purchasedProductRepository.loadPurchasedProducts()
    }
}