package com.alieser.libraryproject.ui.view.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.alieser.libraryproject.R
import com.alieser.libraryproject.data.model.ProductBasket
import com.alieser.libraryproject.databinding.ActivityProductBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment1 = supportFragmentManager.findFragmentById(R.id.productNavHost) as NavHostFragment
        val productNavController = navHostFragment1.navController
        NavigationUI.setupWithNavController(binding.bottomNavigationView,productNavController)

        var badge = binding.bottomNavigationView.getOrCreateBadge(R.id.basketFragment)
        badge.isVisible = true

        var db = Firebase.firestore

        db.collection("Product Basket").addSnapshotListener { value, error ->

            if(value?.documents?.size == 0){

                badge.isVisible = false

            } else {
                var badgeNumber = value?.documents?.size
                badge.isVisible = true
                badge.number = badgeNumber!!
            }
        }

    }
}