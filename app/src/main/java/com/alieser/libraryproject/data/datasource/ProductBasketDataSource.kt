package com.alieser.libraryproject.data.datasource

import androidx.lifecycle.MutableLiveData
import com.alieser.libraryproject.data.model.ProductBasket
import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import javax.inject.Inject
import javax.inject.Named

class ProductBasketDataSource @Inject constructor (@Named("Product Basket")var collectionBasketReference: CollectionReference) {

    var basketList = MutableLiveData<List<ProductBasket>>()


    fun loadBasket() : MutableLiveData<List<ProductBasket>> {

        collectionBasketReference.addSnapshotListener { value, error ->
            if(value != null) {
                var basketArrayList = ArrayList<ProductBasket>()

                for(document in value.documents) {
                    val basket = document.toObject(ProductBasket::class.java)

                    if(basket != null) {
                        basket.basketId = document.id

                        basketArrayList.add(basket)

                    }
                }
                basketList.value = basketArrayList
            }

        }
        return basketList
    }

}