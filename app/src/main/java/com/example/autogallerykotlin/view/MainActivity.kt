package com.example.autogallerykotlin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.example.autogallerykotlin.R
import com.example.autogallerykotlin.data.UserPreferences
import com.example.autogallerykotlin.data.model.Login
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userPreferences = UserPreferences(this)
        userPreferences.authToken.asLiveData().observe(this, Observer {
            Toast.makeText(this, it ?:"Email is Null", Toast.LENGTH_LONG).show()
            startActivity(Intent(this,RegisterActivity::class.java))
        })

    }
}