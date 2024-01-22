package com.alieser.libraryproject.ui.view.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.alieser.libraryproject.R
import com.alieser.libraryproject.data.model.Address
import com.alieser.libraryproject.data.util.AddressBottomSheetFragmentDirections
import com.alieser.libraryproject.data.util.ChangeAddressDialogFragment
import com.alieser.libraryproject.data.util.ProductManager
import com.alieser.libraryproject.data.util.WhichFragment
import com.alieser.libraryproject.databinding.FragmentAddAddressBinding
import com.alieser.libraryproject.databinding.FragmentAddressBinding
import com.alieser.libraryproject.ui.adapter.AddressAdapter
import com.alieser.libraryproject.ui.viewmodel.product.AddressFragmentViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddAddressFragment : Fragment() {

    private lateinit var binding : FragmentAddAddressBinding
    val db = Firebase.firestore
    val auth = Firebase.auth
    var productManager = ProductManager()
    private lateinit var addressFragmentViewModel : AddressFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    fun setNonDefault() {
        addressFragmentViewModel.addressList.observe(viewLifecycleOwner) {
            for(addressObject in it) {
                db.collection("Address List").document("${addressObject.addressId}").update("default",false)
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val tempViewModel : AddressFragmentViewModel by viewModels()

        addressFragmentViewModel = tempViewModel

        val bundle : AddAddressFragmentArgs by navArgs()


        val selectedAddress = bundle.selectedAddress
        val whichFragment = bundle.whichFragment



        var isUpdate = false

        binding = FragmentAddAddressBinding.inflate(inflater, container, false)

        if(!selectedAddress.addressId.equals("")) {
            isUpdate = true
            if(selectedAddress.addressType.equals("Home")) {
                binding.cbHome.isChecked = true
            } else {
                binding.cbWorkplace.isChecked = true
            }


            binding.txtName.setText(selectedAddress.userName)
            binding.txtSurname.setText(selectedAddress.userSurname)
            binding.txtPhoneNumber.setText(selectedAddress.userPhoneNumber)
            binding.textInputLayoutProvince.editText!!.setText(selectedAddress.province)
            binding.textInputLayoutCounty.editText!!.setText(selectedAddress.county)
            binding.txtAddress.setText(selectedAddress.fullAddress)
            binding.txtAddressTitle.setText(selectedAddress.addressTitle)


        }



        val provinceArrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,productManager.loadProvinceList(requireContext()))

        binding.autoCompleteTvProvinces.setAdapter(provinceArrayAdapter)


        binding.autoCompleteTvProvinces.setOnItemClickListener { adapterView, view, i, l ->

            val selectedProvince : String = adapterView.getItemAtPosition(i).toString()

            binding.textInputLayoutCounty.editText!!.setText("")

            val countyArrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,productManager.loadCountyList(selectedProvince))

            binding.autoCompleteTvCounties.setAdapter(countyArrayAdapter)
        }


        binding.cbHome.setOnClickListener {
            binding.cbWorkplace.isChecked = false
        }
        binding.cbWorkplace.setOnClickListener {
            binding.cbHome.isChecked = false
        }

        binding.btnSave.setOnClickListener {

            var addressType : String = ""

            if(binding.cbHome.isChecked) {
                addressType = binding.cbHome.text.toString()

            }
            else {
                addressType = binding.cbWorkplace.text.toString()
            }

            val address = Address(auth.currentUser!!.uid.toString(),"",binding.txtName.text.toString(),binding.txtSurname.text.toString(),
                binding.txtPhoneNumber.text.toString(),addressType,binding.textInputLayoutProvince.editText!!.text.toString()
                ,binding.textInputLayoutCounty.editText!!.text.toString(),binding.txtAddress.text.toString(),
                binding.txtAddressTitle.text.toString(),true)

            if(isUpdate) {
                setNonDefault()
                var dialog = ChangeAddressDialogFragment(selectedAddress.addressId,address,it)

                dialog.show(childFragmentManager,"customDialog")

            }
           else {
               if(whichFragment.equals(WhichFragment.AddressFragment)) {
                   setNonDefault()
                   db.collection("Address List").document().set(address)
                   Navigation.findNavController(it).navigate(R.id.action_addAddressFragment_to_addressFragment)
               }
                else if (whichFragment.equals(WhichFragment.AddressBottomSheetFragment)){

                    setNonDefault()

                    db.collection("Address List").document().set(address)

                    Navigation.findNavController(it).navigate(R.id.action_addAddressFragment_to_order_navigation_graph)

               }
            }

        }
        binding.btnCancel.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.action_addAddressFragment_to_addressFragment)
        }
        binding.ivBack.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_addAddressFragment_to_addressFragment)
        }


        return binding.root
    }

}