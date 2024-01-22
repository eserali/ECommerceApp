package com.alieser.libraryproject.data.datasource

import androidx.lifecycle.MutableLiveData
import com.alieser.libraryproject.data.model.Product
import com.google.firebase.firestore.CollectionReference
import javax.inject.Inject
import javax.inject.Named


class ProductDataSource @Inject constructor(@Named("Products")var collectionReference: CollectionReference) {

    private var productList = MutableLiveData<List<Product>>()

    fun loadProducts() : MutableLiveData<List<Product>> {

        collectionReference.addSnapshotListener { value, error ->
            if(value != null) {
                val productArrayList = ArrayList<Product>()

                for (document in value.documents) {

                    val product = document.toObject(Product::class.java)


                    if(product != null) {
                        product.productId = document.id

                        productArrayList.add(product)
                    }
                }
                productList.value = productArrayList
            }
        }
        return productList

    }
    fun searchProduct(searchWord : String) : MutableLiveData<List<Product>> {

        collectionReference.addSnapshotListener { value, error ->

            if(value != null) {
                val searchArrayList = ArrayList<Product>()

                for (document in value.documents) {

                    val product = document.toObject(Product::class.java)


                    if(product != null && product.productName!!.lowercase().contains(searchWord.lowercase())) {
                        product.productId = document.id

                        searchArrayList.add(product)
                    }
                }
                productList.value = searchArrayList
            }
        }
        return productList

    }



}