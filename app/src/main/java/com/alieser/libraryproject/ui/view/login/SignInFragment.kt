package com.alieser.libraryproject.ui.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.alieser.libraryproject.R
import com.alieser.libraryproject.databinding.FragmentSignInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : Fragment() {
    private lateinit var binding : FragmentSignInBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(inflater, container, false)

        auth = Firebase.auth

        // Mevcut kullanıcı varsa direk giriş yap
        /*val currentUser = auth.currentUser

        if(currentUser != null) {
            Navigation.findNavController(binding.root).navigate(R.id.action_signInFragment_to_mainScreenFragment)
        }else {
            Toast.makeText(this@SignInFragment.requireActivity(),"Enter email and password",Toast.LENGTH_SHORT).show()
        }
        */

        binding.txtSignUp.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_signInFragment_to_signUpFragment)
        }
        binding.btnSignin.setOnClickListener {
            val emailText = binding.etUserName.text.toString().trim()
            val passwordText = binding.etPassword.text.toString().trim()

            if(emailText.isEmpty() || passwordText.isEmpty()) {
                Toast.makeText(this@SignInFragment.requireActivity(),"Enter email and password",Toast.LENGTH_SHORT).show()
            }
            else {
                auth.signInWithEmailAndPassword(emailText,passwordText)
                    .addOnSuccessListener {
                        Navigation.findNavController(binding.root).navigate(R.id.action_signInFragment_to_productActivity)
                    }
                    .addOnFailureListener {
                        Toast.makeText(this@SignInFragment.requireActivity(),it.localizedMessage,Toast.LENGTH_SHORT).show()
                    }
            }

        }


        return binding.root


    }



}