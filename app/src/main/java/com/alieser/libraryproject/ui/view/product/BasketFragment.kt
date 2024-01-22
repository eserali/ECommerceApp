package com.alieser.libraryproject.ui.view.product

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
import com.alieser.libraryproject.data.model.PurchasedProduct
import com.alieser.libraryproject.data.util.ProductManager
import com.alieser.libraryproject.databinding.FragmentBasketBinding
import com.alieser.libraryproject.ui.adapter.ProductBasketAdapter
import com.alieser.libraryproject.ui.viewmodel.product.BasketFragmentViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.Firebase
import com.google.firebase.Timestamp
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BasketFragment : Fragment() {

    private lateinit var binding : FragmentBasketBinding

    private lateinit var viewModel : BasketFragmentViewModel

    var productManager = ProductManager()

    var db = Firebase.firestore
    var auth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    fun loadBasket() {
        viewModel.basketList.observe(viewLifecycleOwner, Observer {productBasketList ->

            val basketAdapter = ProductBasketAdapter(requireContext(),productBasketList)
            binding.rcvMyBasket.adapter = basketAdapter
            binding.rcvMyBasket.layoutManager = LinearLayoutManager(context)

            if(productBasketList.isEmpty()) {

                binding.txtTotalAmount.text = "Total Amount : 0"
            }
            else {

                binding.txtTotalAmount.text = "${productManager.calculateTotalAmount(productBasketList)} ${productBasketList[0].currency}"

            }

        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        return inflater.inflate(R.layout.fragment_basket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val basketTempViewModel : BasketFragmentViewModel by viewModels()

        viewModel = basketTempViewModel

        binding = FragmentBasketBinding.bind(view)

        loadBasket()

        binding.btnOrderConfirmation.setOnClickListener {

            //productManager.addPurchasedProduct(it.context,productBasketList)
            Navigation.findNavController(it).navigate(R.id.action_basketFragment_to_orderActivity)
        }

    }


}