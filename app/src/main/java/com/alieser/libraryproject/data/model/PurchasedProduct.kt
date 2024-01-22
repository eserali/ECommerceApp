package com.alieser.libraryproject.data.model

import com.google.firebase.Timestamp
import java.io.Serializable

data class PurchasedProduct(
    var orderId : String = "",
    var totalAmount : Int = 0,
    var purchasedDate : Timestamp? = null,
    var userId : String = "",
    var productId : String = "",
    var count : Int = 0,
    var productPrice : Int = 0,
    var productName : String = "",
    var imageUrl : String = "",
    var currency : String = "") : Serializable
{
}