package com.alieser.libraryproject.data.repository

import androidx.lifecycle.MutableLiveData
import com.alieser.libraryproject.data.datasource.AddressDataSource
import com.alieser.libraryproject.data.model.Address
import javax.inject.Inject

class AddressRepository @Inject constructor(var addressDataSource: AddressDataSource){

    fun loadAddresses() : MutableLiveData<List<Address>> = addressDataSource.loadAddresses()
}
