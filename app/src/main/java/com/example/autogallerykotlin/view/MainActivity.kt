package com.example.autogallerykotlin.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.autogallerykotlin.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_item,menu)
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
            }else->{
                super.onOptionsItemSelected(item)
            }
        }

    }
}