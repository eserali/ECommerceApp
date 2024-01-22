package com.alieser.libraryproject.data.model

import java.io.Serializable

data class Product(
    var productId : String? = "",
    var productName : String? = "",
    var productPrice : Int? = 0,
    var currency : String? = "",
    var imageUrl : String? = "") : Serializable {
}
// image, product name,price,id,currency 6 ürün product currency = string
// currency id, name, simgesi(icon)