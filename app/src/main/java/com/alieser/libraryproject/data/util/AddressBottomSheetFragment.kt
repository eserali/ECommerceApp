package com.alieser.libraryproject.data.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alieser.libraryproject.R
import com.alieser.libraryproject.data.model.Address
import com.alieser.libraryproject.databinding.FragmentAddressBottomSheetBinding
import com.alieser.libraryproject.ui.adapter.BottomSheetAddressAdapter
import com.alieser.libraryproject.ui.view.product.AddAddressFragment

import com.alieser.libraryproject.ui.viewmodel.product.AddressFragmentViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddressBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentAddressBottomSheetBinding
    private lateinit var addressViewModel : AddressFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    fun loadAddressList() {
        addressViewModel.addressList.observe(viewLifecycleOwner, Observer { addressList ->

            val bottomSheetAddressAdapter = BottomSheetAddressAdapter(requireContext(),addressList)
            binding.rcvBottomSheet.adapter = bottomSheetAddressAdapter
            binding.rcvBottomSheet.layoutManager = LinearLayoutManager(context)

        })
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_address_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddressBottomSheetBinding.bind(view)

        val addressTempViewModel : AddressFragmentViewModel by viewModels()

        addressViewModel = addressTempViewModel

        loadAddressList()

        binding.ivCancel.setOnClickListener {
            dismiss()
        }

        binding.cvAddAddress.setOnClickListener {

            val address = Address("","","","","","","","","","",false)
            val action = AddressBottomSheetFragmentDirections.actionAddressBottomSheetFragmentToAddAddressNestedGraph(address,WhichFragment.AddressBottomSheetFragment)
            val navHost = requireActivity().supportFragmentManager.findFragmentById(R.id.orderNavHost) as NavHostFragment
            navHost.navController.navigate(action)


        }

    }




}