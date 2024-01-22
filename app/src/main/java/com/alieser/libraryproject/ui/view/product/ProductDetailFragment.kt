package com.alieser.libraryproject.ui.view.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.alieser.libraryproject.R
import com.alieser.libraryproject.data.model.Product
import com.alieser.libraryproject.data.util.ProductManager
import com.alieser.libraryproject.databinding.FragmentProductDetailBinding
import com.alieser.libraryproject.tablayout.ViewPagerAdapter
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {

    private lateinit var binding : FragmentProductDetailBinding

    var productManager = ProductManager()

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProductDetailBinding.inflate(inflater, container, false)

        val bundle : ProductDetailFragmentArgs by navArgs()

        val selectedProduct = bundle.product
        val selectedPurchasedProduct = bundle.purchased

        if (!selectedProduct.productId.equals("")) {

            Glide.with(requireContext()).load(selectedProduct.imageUrl).override(270,270).into(binding.ivProductDetail)

            binding.txtProductNameProductDetail.text = selectedProduct.productName
            binding.txtAmount.text = "${selectedProduct.productPrice} ${selectedProduct.currency}"


            binding.fabProductDetail.setOnClickListener {

                Navigation.findNavController(it).navigate(R.id.action_productDetailFragment_to_productFragment)

            }
            binding.btnAddToBasket.setOnClickListener {

                productManager.findProductBasketDocument(selectedProduct)

            }

        }
        else if(!selectedPurchasedProduct.productId.equals("")) {

            Glide.with(requireContext()).load(selectedPurchasedProduct.imageUrl).override(270,270).into(binding.ivProductDetail)

            binding.txtProductNameProductDetail.text = selectedPurchasedProduct.productName

            binding.txtAmount.text = "${selectedPurchasedProduct.productPrice} ${selectedPurchasedProduct.currency}"

            binding.fabProductDetail.setOnClickListener {

                Navigation.findNavController(it).navigate(R.id.action_productDetailFragment_to_purchasedProductFragment)

            }
            binding.btnAddToBasket.setOnClickListener {

                val product = Product(selectedPurchasedProduct.productId,selectedPurchasedProduct.productName,selectedPurchasedProduct.productPrice,
                    selectedPurchasedProduct.currency,selectedPurchasedProduct.imageUrl)

                productManager.findProductBasketDocument(product)

            }
        }

        viewPagerAdapter = ViewPagerAdapter(childFragmentManager,lifecycle)

        binding.viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabLayout,binding.viewPager) {tab, position ->

            tab.text = when(position) {
                0 -> "Features"
                1 -> "Rating"
                2 -> "Questions"
                else ->  "Features"
            }

        }.attach()

        //var gg = productManager.getProvinceAndCounty()


        return binding.root
    }

}