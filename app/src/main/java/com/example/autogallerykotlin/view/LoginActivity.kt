package com.example.autogallerykotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.autogallerykotlin.R
import com.example.autogallerykotlin.data.UserPreferences
import com.example.autogallerykotlin.databinding.ActivityLoginBinding
import com.example.autogallerykotlin.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    lateinit var userPreferences: UserPreferences
    private val viewModel : LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userPreferences= UserPreferences(this)

        viewModel.login.observe(this){ loginResponse->

            lifecycleScope.launch {
                userPreferences.saveAuthToken(loginResponse.body()?.email.toString())
            }


            /*
            if (loginResponse.isSuccessful){
                Toast.makeText(this,"basarili", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"basarisiz", Toast.LENGTH_LONG).show()
            }*/
        }



        binding.loginButton.setOnClickListener{

            val email = binding.loginEmailEditText.text.toString().trim()
            val password = binding.loginPasswordEditText.text.toString().trim()
/*
            if(email.isNullOrEmpty()||password.isNullOrEmpty()){
                Toast.makeText(this, "email veya şifre hatali", Toast.LENGTH_LONG).show()
            }
            */


            // todo: input validations
            viewModel.login(email, password)
        }

    }


}