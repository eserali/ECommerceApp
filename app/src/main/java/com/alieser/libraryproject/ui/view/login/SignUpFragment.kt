package com.alieser.libraryproject.ui.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.alieser.libraryproject.R
import com.alieser.libraryproject.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment() {
    private lateinit var binding : FragmentSignUpBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater,container,false)
        auth = Firebase.auth

        binding.btnSignUp.setOnClickListener {
            val emailText = binding.etUserNameSignUp.text.toString().trim()
            val passwordText = binding.etPasswordSignUp.text.toString().trim()



            if(emailText.isNotEmpty() && passwordText.isNotEmpty() && emailText.trim().length >= 2 && passwordText.trim().length >= 2) {

                auth.createUserWithEmailAndPassword(emailText,passwordText)
                    .addOnSuccessListener {
                        // Succes olunca çağrılacak buraya Toast message verilebilir. başarıyla kayıt oldunuz diye
                        Navigation.findNavController(binding.root).navigate(R.id.action_signUpFragment_to_logInFragment)
                    }
                    .addOnFailureListener {
                        // Failure olunca çağırılacak.
                        Toast.makeText(this@SignUpFragment.requireActivity(),it.localizedMessage,Toast.LENGTH_SHORT).show()
                    }

            } else if(emailText.isEmpty() || passwordText.isEmpty()){

                Toast.makeText(this@SignUpFragment.requireActivity(),"Please enter email and password",
                    Toast.LENGTH_SHORT).show()

            } else if (emailText.length < 2 && passwordText.length < 2) {

                Toast.makeText(this@SignUpFragment.requireActivity(),"Username and password cannot be less than 2 digits",
                    Toast.LENGTH_SHORT).show()
            }
        }


        return binding.root
    }


}