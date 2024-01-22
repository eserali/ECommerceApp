package com.alieser.libraryproject.data.util

class County() {

    var countyId : Int? = null
    var countyName : String? = null
    var city : City? = null

    fun set(countyId : Int, countyName : String, city : City) : County{
        this.countyId = countyId
        this.countyName = countyName
        this.city = city
        return this
    }
}