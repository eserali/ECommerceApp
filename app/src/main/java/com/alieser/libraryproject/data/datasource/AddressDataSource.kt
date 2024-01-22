package com.alieser.libraryproject.data.datasource

import androidx.lifecycle.MutableLiveData
import com.alieser.libraryproject.data.model.Address
import com.google.firebase.firestore.CollectionReference
import javax.inject.Inject
import javax.inject.Named

class AddressDataSource @Inject constructor(@Named("Address List") var collectionReference: CollectionReference){

    private var addressList = MutableLiveData<List<Address>>()

    fun loadAddresses() : MutableLiveData<List<Address>> {

        collectionReference.addSnapshotListener { value, error ->

            if(value != null) {

                val addressArrayList = ArrayList<Address>()

                for (document in value.documents) {

                    val address = document.toObject(Address::class.java)

                    if ( address != null) {
                        address.addressId = document.id

                        addressArrayList.add(address)
                    }
                }
                addressList.value = addressArrayList

            }
        }

        return addressList
    }
}
