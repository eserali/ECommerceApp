package com.alieser.libraryproject.data.model

import android.text.BoringLayout
import java.io.Serializable

class Address (

    var userId : String = "",
    var addressId : String = "",
    var userName : String = "",
    var userSurname : String = "",
    var userPhoneNumber : String = "",
    var addressType : String = "",
    var province : String = "",
    var county : String = "",
    var fullAddress : String = "",
    var addressTitle : String = "",
    var default : Boolean = false

) : Serializable {
}