package com.example.autogallerykotlin.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.autogallerykotlin.R
import com.example.autogallerykotlin.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView = binding.bottomNavigationView
        setupWithNavController(bottomNavigationView,navController)

    }
/*
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.bottom_nav_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.SignOut->{
                val sharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                sharedPreferences.getString("users_id",null)
                editor.clear()
                editor.apply()

                startActivity(Intent(this, LoginActivity::class.java))
                true
            }
            else->{
                super.onOptionsItemSelected(item)
            }
        }
    }*/
}