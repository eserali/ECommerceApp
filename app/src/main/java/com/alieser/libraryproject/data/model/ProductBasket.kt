package com.alieser.libraryproject.data.model

import com.google.firebase.Firebase
import com.google.firebase.Timestamp
import java.io.Serializable
import java.time.Instant
import java.util.Date

data class ProductBasket(
                    var basketId : String? = "",
                    var userId : String? = "",
                    var productId : String? = "",
                    var productName : String? = "",
                    var productPrice : Int = 0,
                    var currency : String? = "",
                    var imageUrl : String? = "",
                    var count : Int = 1,
                    var addDate: Timestamp? = null,
                    var updateDate : Timestamp? =null
                    )  : Serializable {
}