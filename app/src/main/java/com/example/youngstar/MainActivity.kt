package com.example.youngstar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.youngstar.databinding.ActivityMainBinding
import com.example.youngstar.utils.hide
import com.example.youngstar.utils.show

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.fragmentContainerView)
        binding.bottomBar.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.facilityFragment -> {
                    hideBottom()
                }
                R.id.levelUpdateFragment -> {
                    hideBottom()
                }
                R.id.sportFacilitiesFragment -> {
                    hideBottom()
                }
                R.id.writeTrainingFragment -> {
                    hideBottom()
                }
                else -> showBottom()
            }
        }

//        setupSmoothBottomMenu()

    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun hideBottom() {
        binding.bottomBar.animate().translationY(binding.bottomBar.height.toFloat())
        binding.bottomBar.hide()
    }

    private fun showBottom() {
        binding.bottomBar.animate().translationY(0F)
        binding.bottomBar.show()
    }
}