package com.alieser.libraryproject.ui.view.order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.alieser.libraryproject.R
import com.alieser.libraryproject.databinding.ActivityOrderBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding  = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val orderNavHostFragment = supportFragmentManager.findFragmentById(R.id.orderNavHost) as NavHostFragment
        val orderNavController = orderNavHostFragment.navController



    }
}