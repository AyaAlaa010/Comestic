package com.aya.comestic.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.aya.comestic.R
import com.aya.comestic.databinding.ActivityMainBinding
import com.aya.comestic.ui.favourite.FavouritesFragment
import com.aya.comestic.ui.home.HomeFragment
import com.aya.comestic.ui.profile.ProfileFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    private fun init(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView_main) as NavHostFragment
        navController = navHostFragment.navController
    }


    private var listener = NavController.OnDestinationChangedListener { _, destination, _ ->

        if (destination.id == R.id.productDetailsFragment) {
            binding.bottomNavigationView.visibility = View.GONE

        } else {
            binding.bottomNavigationView.visibility = View.VISIBLE
        }

    }

    override fun onResume() {
        super.onResume()
        val navController = findNavController(R.id.fragmentContainerView_main)
        binding.bottomNavigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener(listener)

    }

    override fun onPause() {
        navController.removeOnDestinationChangedListener(listener)
        super.onPause()
    }
}
