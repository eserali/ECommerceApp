package com.alieser.libraryproject.ui.view.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
import com.alieser.libraryproject.R
import com.alieser.libraryproject.data.model.Address
import com.alieser.libraryproject.data.util.WhichFragment
import com.alieser.libraryproject.databinding.FragmentAddressBinding
import com.alieser.libraryproject.ui.adapter.AddressAdapter
import com.alieser.libraryproject.ui.viewmodel.product.AddressFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // koymazsam viewmodel çalışmaz !
class AddressFragment : Fragment() {

    private lateinit var binding : FragmentAddressBinding

    private lateinit var viewModel : AddressFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    fun loadAddresses() {
        viewModel.addressList.observe(viewLifecycleOwner) {

            val addressAdapter = AddressAdapter(it)

            binding.rcvAddresses.adapter = addressAdapter

            binding.rcvAddresses.layoutManager = LinearLayoutManager(context)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_address, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAddressBinding.bind(view)

        val tempViewModel : AddressFragmentViewModel by viewModels()

        viewModel = tempViewModel

        loadAddresses()

        binding.fabAddAddress.setOnClickListener {
            val address = Address("","","","","","","","","","")
            val action = AddressFragmentDirections.actionAddressFragmentToAddAddressFragment(address,WhichFragment.AddressFragment)
            Navigation.findNavController(it).navigate(action)
        }
        binding.ivBackButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_addressFragment_to_accountFragment)
        }
    }



}