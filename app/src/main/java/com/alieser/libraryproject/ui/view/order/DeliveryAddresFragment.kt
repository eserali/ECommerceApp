package com.alieser.libraryproject.ui.view.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.alieser.libraryproject.R
import com.alieser.libraryproject.data.model.Address
import com.alieser.libraryproject.data.util.ProductManager
import com.alieser.libraryproject.databinding.FragmentDeliveryAddresBinding
import com.alieser.libraryproject.ui.adapter.BottomSheetAddressAdapter
import com.alieser.libraryproject.ui.adapter.OrderProductBasketAdapter
import com.alieser.libraryproject.ui.viewmodel.product.AddressFragmentViewModel
import com.alieser.libraryproject.ui.viewmodel.product.BasketFragmentViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeliveryAddresFragment : Fragment() {
    private lateinit var basketViewModel : BasketFragmentViewModel
    private lateinit var addressViewModel : AddressFragmentViewModel
    private var productManager = ProductManager()
    private lateinit var binding : FragmentDeliveryAddresBinding
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun loadBasket() {
        basketViewModel.basketList.observe(viewLifecycleOwner, Observer { productBasketList ->
            val orderProductBasketAdapter = OrderProductBasketAdapter(requireContext(),productBasketList)
            binding.rcvOrderProductBasket.adapter = orderProductBasketAdapter
            binding.rcvOrderProductBasket.layoutManager = LinearLayoutManager(context)

            if(productBasketList.isEmpty()) {

                binding.txtAmountOrder.text = ""
            }
            else {
                val totalAmount = "${productManager.calculateTotalAmount(productBasketList)} ${productBasketList[0].currency}"
                binding.txtAmountOrder.text = "${totalAmount}"

                binding.btnConfirmOrder.setOnClickListener {
                    val action = DeliveryAddresFragmentDirections.actionDeliveryAddresFragmentToCreditCardInfoFragment(totalAmount)
                    Navigation.findNavController(it).navigate(action)
                }

            }
        })
    }

    fun loadDefaultAddress() {
        addressViewModel.addressList.observe(viewLifecycleOwner, Observer { addressList ->

          for(address in addressList.filter {
              it.default
          }) {
              binding.txtDeliveryTitle.text = address.addressTitle
              binding.txtFullAddress.text = "${address.fullAddress} ${address.county} / ${address.province}"
          }

        })
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_delivery_addres, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDeliveryAddresBinding.bind(view)

        val basketTempViewModel : BasketFragmentViewModel by viewModels()
        val addressTempViewModel : AddressFragmentViewModel by viewModels()

        addressViewModel = addressTempViewModel

        basketViewModel = basketTempViewModel

        loadBasket()
        loadDefaultAddress()


        binding.txtAddOrChange.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_deliveryAddresFragment_to_addressBottomSheetFragment)
        }

    }

    override fun onResume() {
        super.onResume()
        val basketTempViewModel : BasketFragmentViewModel by viewModels()
        val addressTempViewModel : AddressFragmentViewModel by viewModels()

        addressViewModel = addressTempViewModel

        basketViewModel = basketTempViewModel

        loadBasket()
        loadDefaultAddress()
    }



}