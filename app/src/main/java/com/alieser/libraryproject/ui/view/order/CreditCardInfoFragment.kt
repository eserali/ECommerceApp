package com.alieser.libraryproject.ui.view.order

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.alieser.libraryproject.R
import com.alieser.libraryproject.data.model.Address
import com.alieser.libraryproject.data.util.AddressBottomSheetFragmentDirections
import com.alieser.libraryproject.data.util.ProductManager
import com.alieser.libraryproject.databinding.FragmentCreditCardInfoBinding
import com.alieser.libraryproject.ui.viewmodel.product.AddressFragmentViewModel
import com.alieser.libraryproject.ui.viewmodel.product.BasketFragmentViewModel
import com.google.apphosting.datastore.testing.DatastoreTestTrace.ValidationRule
import dagger.hilt.android.AndroidEntryPoint
import java.lang.NumberFormatException

@AndroidEntryPoint
class CreditCardInfoFragment : Fragment() {
    private lateinit var binding : FragmentCreditCardInfoBinding
    var productManager = ProductManager()
    private lateinit var basketViewModel : BasketFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreditCardInfoBinding.inflate(inflater,container,false)

        val bundle : CreditCardInfoFragmentArgs by navArgs()

        val totalAmount = bundle.totalAmount
        binding.txtAmountOrder.text = totalAmount

        val basketTempViewModel : BasketFragmentViewModel by viewModels()

        basketViewModel = basketTempViewModel

        basketViewModel.basketList.observe(viewLifecycleOwner) {productBasketlist ->
            binding.btnConfirmOrder.setOnClickListener {
                productManager.addPurchasedProduct(productBasketlist)
                Navigation.findNavController(it).navigate(R.id.action_creditCardInfoFragment_to_purchasedProductNestedGraph)
            }
        }

        binding.etCardNumber.doOnTextChanged { text, start, before, count ->
            binding.txtCardNumber.text = text.toString()

            if(text!!.length < 19) {
                try {
                    binding.etCardNumber.error = "Enter your 16 digits card number"
                }catch (e : Exception) {
                    e.localizedMessage
                }
            }
            val formattedText = text.toString().replace(" ", "").chunked(4).joinToString(" ")

            if (formattedText != text.toString()) {
                binding.etCardNumber.setText(formattedText)
                binding.etCardNumber.setSelection( binding.etCardNumber.length())
            }
        }
        binding.etExpireDate.doOnTextChanged { text, start, before, count ->
            binding.txtExpireDate.text = text.toString()
            val formattedText = text.toString().replace("/", "").chunked(2).joinToString("/")

            if (formattedText != text.toString()) {
                binding.etExpireDate.setText(formattedText)
                binding.etExpireDate.setSelection( binding.etExpireDate.length())
            }

        }
        binding.etCVV.doOnTextChanged { text, start, before, count ->
            binding.txtCVV.text = text.toString()

            if(text!!.length < 3) {
                try {
                    binding.etCVV.error = "Enter your 3 digits CVV number"
                }catch (e : Exception) {
                    e.localizedMessage
                }
            }
        }




        return binding.root


    }

}