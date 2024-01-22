package com.alieser.libraryproject.data.util

import android.content.Context
import android.widget.Toast
import com.alieser.libraryproject.data.model.CountyEntity
import com.alieser.libraryproject.data.model.Product
import com.alieser.libraryproject.data.model.ProductBasket
import com.alieser.libraryproject.data.model.ProvinceEntity
import com.alieser.libraryproject.data.model.PurchasedProduct
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.Firebase
import com.google.firebase.Timestamp
import com.google.firebase.Timestamp.now
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import java.lang.Exception

class ProductManager {
    var auth = Firebase.auth
    var db = Firebase.firestore
    var productBasket = Firebase.firestore.collection("Product Basket")

    fun calculateTotalAmount(productBasketList: List<ProductBasket>): Int {

        var totalAmount = 0

        for (productBasket in productBasketList) {
            val totalCount = productBasket.count
            val totalPrice = productBasket.productPrice

            totalAmount += totalCount * totalPrice
        }
        return totalAmount
    }

    fun addToBasket(product: Product, count: Int) {

        val addDate: Timestamp = now()
        val updateDate: Timestamp = now()

        if (count <= 10) {
            var product = ProductBasket(
                "",
                auth.currentUser?.uid!!,
                product.productId!!,
                product.productName!!,
                product.productPrice!!,
                product.currency!!,
                product.imageUrl!!,
                count,
                addDate,
                updateDate
            )

            productBasket.document("${product.productId}").set(product)
        } else {
            throw Exception("You can add maximum 10 products to the basket")
        }
    }

    fun findProductBasketDocument(product: Product) {
        productBasket.whereEqualTo("productId", product.productId).get()
            .addOnSuccessListener { documents ->

                if (documents.isEmpty) {

                    addToBasket(product, 1)
                } else {
                    for (document in documents) {

                        var basket = document.toObject(ProductBasket::class.java)

                        var count = basket.count + 1

                        addToBasket(product, count)

                    }
                }

            }
            .addOnFailureListener { exception ->
                throw Exception("Can't find the document")
            }
    }

    fun addPurchasedProduct(productBasketList: List<ProductBasket>) {

        val orderDate: Timestamp = now()

        for (productBasket in productBasketList) {

            val totalAmount = productBasket.count * productBasket.productPrice

            val purchasedProduct = PurchasedProduct(
                "",
                totalAmount,
                orderDate,
                auth.currentUser!!.uid,
                productBasket.productId!!,
                productBasket.count,
                productBasket.productPrice,
                productBasket.productName!!,
                productBasket.imageUrl!!,
                productBasket.currency!!
            )

            db.collection("Purchased Product").document()
                .set(purchasedProduct)// ürün başarıyla alındı vs. yazayım mı sor
            db.collection("Product Basket").document("${productBasket.productId}").delete()
        }
    }
    /*
    fun getProvinceAndCounty() : ArrayList<ProvideItem>{

        var provideItems = ArrayList<ProvideItem>()

        db.collection("Province List").get().addOnSuccessListener { result ->
            if (result != null) {
                for (province in result.documents) {
                    var documentId = province.id
                    val province = province.toObject(Province::class.java)
                    if (province != null) {
                        var provideItem = ProvideItem()
                        var countyList = ArrayList<County>()
                        var city = City().set(province.licenseNumber, province.provinceName!!, 10)

                        db.collection("Province List").document("${documentId}")
                            .collection("County List").get()
                            .addOnSuccessListener { resultForCounty ->
                                if (resultForCounty != null) {
                                    for (county in resultForCounty.documents) {
                                        val county = county.toObject(CountyEntity::class.java)
                                        if (county != null) {
                                            var countyObject = County().set(
                                                county.countyId!!,
                                                county.countyName!!,
                                                city
                                            )
                                            countyList.add(countyObject)

                                        }
                                    }
                                }
                            }
                        provideItems.add(provideItem.set(city,countyList))
                    }
                }
            }
        }
        return provideItems
    }

    class ProvideItem() {
        var city = City()
        var countyList = ArrayList<County>()

        fun set(city: City, countyList: ArrayList<County>) : ProvideItem{
            this.city = city
            this.countyList = countyList
            return this
        }


    }
*/

    fun loadProvinceList(context: Context) : ArrayList<String> {

        var provinceArrayList = ArrayList<String>()

        db.collection("Province List").get().addOnSuccessListener { result ->

            if (result != null) {

                for (province in result.documents) {

                    val provinceEntity = province.toObject(ProvinceEntity::class.java)


                    if (provinceEntity != null) {

                        provinceArrayList.add(provinceEntity.provinceName!!)

                    } else {

                        Toast.makeText(context, "Not found", Toast.LENGTH_LONG).show()
                    }

                }

            }

        }
        return provinceArrayList

    }


    fun loadCountyList(selectedProvince: String): ArrayList<String> {
        var selectedProvinceId: String
        var countyArrayList = ArrayList<String>()


        db.collection("Province List").whereEqualTo("provinceName", selectedProvince).get()
            .addOnSuccessListener {
                for (document in it.documents) {

                    selectedProvinceId = document.id

                    db.collection("Province List").document("${selectedProvinceId}")
                        .collection("County List").get()
                        .addOnSuccessListener { result ->

                            if (result != null) {

                                for (county in result.documents) {

                                    val county = county.toObject(CountyEntity::class.java)

                                    if (county != null) {
                                        countyArrayList.add(county.countyName!!)

                                    }

                                }

                            }

                        }

                }

            }

        return countyArrayList
    }

}
