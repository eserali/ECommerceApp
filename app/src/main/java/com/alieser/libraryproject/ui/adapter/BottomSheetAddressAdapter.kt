package com.alieser.libraryproject.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.alieser.libraryproject.R
import com.alieser.libraryproject.data.model.Address
import com.alieser.libraryproject.data.util.AddressBottomSheetFragment
import com.alieser.libraryproject.databinding.AddressBottomSheetRcvRowBinding
import com.alieser.libraryproject.ui.view.order.DeliveryAddresFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class BottomSheetAddressAdapter(var context: Context,val addressList : List<Address>) : RecyclerView.Adapter<BottomSheetAddressAdapter.BottomSheetAddressViewHolder>() {
    val db = Firebase.firestore
    class BottomSheetAddressViewHolder(val rowBinding : AddressBottomSheetRcvRowBinding) : RecyclerView.ViewHolder(rowBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BottomSheetAddressViewHolder {
        val binding = AddressBottomSheetRcvRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BottomSheetAddressViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return addressList.size
    }

    override fun onBindViewHolder(holder: BottomSheetAddressViewHolder, position: Int) {
        val address = addressList[position]
        val binding = holder.rowBinding

        binding.ivOptions.setOnClickListener {
            val popup = PopupMenu(context,binding.ivOptions)
            popup.inflate(R.menu.bottom_sheet_row_menu)


            popup.setOnMenuItemClickListener(object  : PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(p0: MenuItem?): Boolean {




                    /*
                    p0!!.setOnMenuItemClickListener {

                        if(it.itemId.equals(R.id.editAddress)) {

                        }
                    }*/
                    return true
                }


            })
            popup.show()
        }
        binding.txtAddressTitleBottomSheet.text = address.addressTitle
        binding.txtFullAddressBottomSheet.text = address.fullAddress
        binding.txtProvinceCounty.text = "${address.county} / ${address.province}"
        binding.cbDefault.isChecked = address.default

        binding.cbDefault.setOnCheckedChangeListener { compoundButton, b ->
            if(b && binding.cbDefault.isChecked) {
                db.collection("Address List").document("${address.addressId}").update("default",true)

                for(otherAddress in addressList.filter {
                    !it.addressId.equals(address.addressId)
                }) {
                    db.collection("Address List").document("${otherAddress.addressId}").update("default",false)
                }
               /* val addressBottomSheetFragment = AddressBottomSheetFragment()
                addressBottomSheetFragment.dismiss()*/
            }
         }

        /*
        binding.cbDefault.setOnClickListener {
            if(binding.cbDefault.isChecked) {
                db.collection("Address List").document("${address.addressId}").update("default",true)


                for(otherAddress in addressList.filter {
                    !it.addressId.equals(address.addressId)
                }) {
                    db.collection("Address List").document("${otherAddress.addressId}").update("default",false)

                }
            }

            /*val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            val navController = navHostFragment.navController*/

        }*/

    }
}