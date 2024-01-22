package com.alieser.libraryproject.data.datasource

import androidx.lifecycle.MutableLiveData
import com.alieser.libraryproject.data.model.PurchasedProduct
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.Query
import javax.inject.Inject
import javax.inject.Named

class PurchasedProductDataSoruce @Inject constructor (@Named("Purchased Product")var collectionReferece : CollectionReference) {

    val purchasedProductList = MutableLiveData<List<PurchasedProduct>>()

    fun loadPurchasedProducts() : MutableLiveData<List<PurchasedProduct>> {

        val purchasedProductArrayList = ArrayList<PurchasedProduct>()



        collectionReferece.orderBy("purchasedDate",Query.Direction.DESCENDING).addSnapshotListener { value, error ->

            if(value != null) {

                purchasedProductArrayList.clear()

                for(document in value.documents) {

                    val purchasedProduct = document.toObject(PurchasedProduct::class.java)


                    if (purchasedProduct != null) {

                        purchasedProduct.orderId = document.id

                        purchasedProductArrayList.add(purchasedProduct)
                    }

                }
                purchasedProductList.value = purchasedProductArrayList

            }
        }
        return purchasedProductList
    }


}

