package com.example.android3_hw8

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.android3_hw8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        findNavController(R.id.nav_host_fragment_activity_main).addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.detailsFragment){
                getSupportActionBar()?.setTitle(R.string.details_label)
            } else if(destination.id == R.id.mainFragment) {
                getSupportActionBar()?.setTitle(R.string.home_label)
            }
            //.....
        }
    }

}