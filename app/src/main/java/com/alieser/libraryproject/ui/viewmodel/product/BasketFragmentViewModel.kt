package com.alieser.libraryproject.ui.viewmodel.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alieser.libraryproject.data.model.ProductBasket
import com.alieser.libraryproject.data.repository.ProductBasketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class BasketFragmentViewModel @Inject constructor (var productBasketRepository: ProductBasketRepository): ViewModel() {

    var basketList = MutableLiveData<List<ProductBasket>>()

    init {
        loadBasket()
    }

    fun loadBasket() {
       basketList = productBasketRepository.loadBasket()
    }

}