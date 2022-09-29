
package com.example.autogallerykotlin.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.autogallerykotlin.R
import com.example.autogallerykotlin.databinding.ActivityMainBinding
import com.example.autogallerykotlin.ui.fragment.AddAdvertiseFragment
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

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView = binding.bottomNavigationView
        setupWithNavController(bottomNavigationView, navController)

        binding.addAdvertiseFAB.setOnClickListener {

            val addAdvertiseFragment = AddAdvertiseFragment()
            val fragment : Fragment? = supportFragmentManager.findFragmentByTag(addAdvertiseFragment::class.java.simpleName)

            if(fragment !is AddAdvertiseFragment){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, addAdvertiseFragment, AddAdvertiseFragment::class.java.simpleName )
                    .commit()
            }

            binding.bottomNavigationView.visibility = View.GONE
            binding.navigationBottomBar.visibility = View.GONE
            binding.addAdvertiseFAB.visibility = View.GONE

        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
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
    }
}