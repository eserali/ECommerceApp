package com.alieser.libraryproject.data.util

class City () {
    var provinceId : Int? = null
    var provinceName : String? = null
    var licenseNumber : Int? = null

    fun set(provinceId : Int, provinceName : String, licenseNumber : Int) : City{
        this.provinceId = provinceId
        this.provinceName = provinceName
        this.licenseNumber = licenseNumber
        return this
    }

}