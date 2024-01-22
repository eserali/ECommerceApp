package com.alieser.libraryproject.data.util

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import com.alieser.libraryproject.R
import com.alieser.libraryproject.data.model.Address
import com.alieser.libraryproject.databinding.CustomDialogFragmentBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class ChangeAddressDialogFragment(var addressId : String,var address : Address,var viewForNav: View) : DialogFragment() {

    val db = Firebase.firestore

    private lateinit var binding : CustomDialogFragmentBinding

    fun setAddress() {

        db.collection("Address List").document(addressId).set(address)
        Navigation.findNavController(viewForNav).navigate(R.id.action_addAddressFragment_to_addressFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = CustomDialogFragmentBinding.inflate(layoutInflater)

        binding.btnYes.setOnClickListener {

            setAddress()

            dismiss()
        }
        binding.btnNo.setOnClickListener {
            dismiss()
            Navigation.findNavController(viewForNav).navigate(R.id.action_addAddressFragment_to_addressFragment)
        }
        return binding.root
    }

} /*
        binding.btnCancel.setOnClickListener {
            // değişiklikleri iptal etmek istiyor musun evet derse address fragmenta yolla
            // no derse dialogu kapat
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Delete Changes")
                .setMessage("Are you sure you want to delete changes?")
                .setPositiveButton("Yes") {d,i ->
                    Navigation.findNavController(it).navigate(R.id.action_addAddressFragment_to_addressFragment)
                }
                .setNegativeButton("No") {d,i ->
                    d.cancel()
                }.show()
        }
        binding.btnSave.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Save Changes")
                .setMessage("Are you sure you want to save changes?")
                .setPositiveButton("Yes") {d,i ->
                    db.collection("Address List").document("${selectedAddress.addressId}").delete()
                    Navigation.findNavController(it).navigate(R.id.action_addAddressFragment_to_addressFragment)
                }
                .setNegativeButton("No") {d,i ->
                    d.cancel()
                }.show()
        }*/