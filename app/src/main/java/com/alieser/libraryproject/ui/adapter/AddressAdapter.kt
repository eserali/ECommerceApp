package com.alieser.libraryproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.alieser.libraryproject.R
import com.alieser.libraryproject.data.model.Address
import com.alieser.libraryproject.data.util.WhichFragment
import com.alieser.libraryproject.databinding.AddressRcvRowBinding
import com.alieser.libraryproject.ui.view.product.AddressFragmentDirections
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class AddressAdapter(val addressList : List<Address>) : RecyclerView.Adapter<AddressAdapter.AddressViewHolder>() {

    val db = Firebase.firestore

    class AddressViewHolder(val addressRowBinding : AddressRcvRowBinding) : RecyclerView.ViewHolder(addressRowBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {

        val binding = AddressRcvRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AddressViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return addressList.size
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {

        val address = addressList[position]

        val binding = holder.addressRowBinding

        if(address.addressType.equals("Home")) {

            binding.txtAddressTitleRow.text = address.addressTitle
            binding.ivAddressTypeIcon.setImageResource(R.drawable.home_icon)
            binding.txtFullName.text = "${address.userName} ${address.userSurname}"
            binding.txtPhoneNumberRow.text = address.userPhoneNumber
            binding.txtProvinceRow.text = "${address.province} ${address.county}"
            binding.txtAddressRow.text = "${address.fullAddress}"

        }
        else {

            binding.ivAddressTypeIcon.setImageResource(R.drawable.job_icon)
            binding.txtAddressTitleRow.text = address.addressTitle
            binding.txtFullName.text = "${address.userName} ${address.userSurname}"
            binding.txtPhoneNumberRow.text = address.userPhoneNumber
            binding.txtProvinceRow.text = "${address.province} ${address.county}"
            binding.txtAddressRow.text = "${address.fullAddress}"
        }

        binding.ivDeleteAddress.setOnClickListener {
            db.collection("Address List").document("${address.addressId}").delete()
        }
        binding.ivEdit.setOnClickListener {
            val action = AddressFragmentDirections.actionAddressFragmentToAddAddressFragment(address,WhichFragment.AddressFragment)

            Navigation.findNavController(it).navigate(action)
        }

        binding.switchSetDefault.isChecked = address.default

        binding.switchSetDefault.setOnCheckedChangeListener { compoundButton, b ->

            if (b) {
                for(i in addressList) {
                    if (i.equals(address)) {
                        db.collection("Address List").document("${i.addressId}")
                            .update("default", true)
                    }else {
                        db.collection("Address List").document("${i.addressId}")
                            .update("default", false)
                    }

                }
            }else {
                db.collection("Address List").document("${address.addressId}")
                    .update("default", false)
            }
        }

    }
}