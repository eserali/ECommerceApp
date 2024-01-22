package com.alieser.libraryproject.ui.viewmodel.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alieser.libraryproject.data.model.Address
import com.alieser.libraryproject.data.repository.AddressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddressFragmentViewModel @Inject constructor(var addressRepository: AddressRepository) : ViewModel() {

    var addressList = MutableLiveData<List<Address>>()

    init {
        loadAddresses()
    }

    fun loadAddresses() {
        addressList = addressRepository.loadAddresses()
    }
}

