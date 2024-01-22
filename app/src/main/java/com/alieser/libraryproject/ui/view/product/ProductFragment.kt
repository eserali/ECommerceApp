package com.alieser.libraryproject.ui.view.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.alieser.libraryproject.R
import com.alieser.libraryproject.databinding.FragmentProductBinding
import com.alieser.libraryproject.ui.adapter.ProductAdapter
import com.alieser.libraryproject.ui.viewmodel.product.ProductFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : Fragment() {

    private lateinit var binding : FragmentProductBinding

    private lateinit var viewModel : ProductFragmentViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
    fun loadProducts() {

        viewModel.productList.observe(viewLifecycleOwner, Observer {

            val productAdapter = ProductAdapter(requireContext(),it)
            binding.rcvProducts.adapter = productAdapter
            binding.rcvProducts.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

            binding.svProduct.setOnQueryTextListener(object : OnQueryTextListener {

                override fun onQueryTextSubmit(p0: String): Boolean {
                    viewModel.searchProduct(p0)
                    return true
                }

                override fun onQueryTextChange(p0: String): Boolean {
                    viewModel.searchProduct(p0)
                    return true
                }

            })

        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tempViewModel : ProductFragmentViewModel by viewModels()

        viewModel = tempViewModel

        val fragmentBinding = FragmentProductBinding.bind(view)

        binding = fragmentBinding

        loadProducts()


    }

    override fun onResume() {
        super.onResume()
        loadProducts()
    }

}
