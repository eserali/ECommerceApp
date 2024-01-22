package com.alieser.libraryproject.ui.view.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.alieser.libraryproject.R
import com.alieser.libraryproject.databinding.FragmentBasketBinding
import com.alieser.libraryproject.databinding.FragmentPurchasedProductBinding
import com.alieser.libraryproject.ui.adapter.ProductAdapter
import com.alieser.libraryproject.ui.adapter.PurchasedProductAdapter
import com.alieser.libraryproject.ui.viewmodel.product.ProductFragmentViewModel
import com.alieser.libraryproject.ui.viewmodel.product.PurchasedProductFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PurchasedProductFragment : Fragment() {

    private lateinit var binding : FragmentPurchasedProductBinding

    private lateinit var viewModel: PurchasedProductFragmentViewModel

    fun loadPurhcasedProducts() {

        viewModel.purchasedProductList.observe(viewLifecycleOwner, Observer {

            val purchasedProductAdapter = PurchasedProductAdapter(it)
            binding.rcvPurchased.adapter = purchasedProductAdapter

            binding.rcvPurchased.layoutManager = LinearLayoutManager(context)

        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_purchased_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPurchasedProductBinding.bind(view)

        val tempViewModel : PurchasedProductFragmentViewModel by viewModels()

        viewModel = tempViewModel

        loadPurhcasedProducts()

    }

}