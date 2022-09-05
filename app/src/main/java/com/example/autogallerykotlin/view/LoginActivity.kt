package com.example.autogallerykotlin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.autogallerykotlin.R
import com.example.autogallerykotlin.databinding.ActivityLoginBinding
import com.example.autogallerykotlin.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.login.observe(this) { loginResponse ->

            if (loginResponse.isSuccessful) {

                println(loginResponse.body()?.email)

                if (loginResponse.body()?.id != null && loginResponse.body()?.email !=null) {

                    startActivity(Intent(this, MainActivity::class.java))

                    Toast.makeText(this, "basarili", Toast.LENGTH_LONG).show()
                } else {

                    Toast.makeText(this, "Mailiniz veya şifreniz hatalıdır", Toast.LENGTH_LONG)
                        .show()
                }




            } else {
                Toast.makeText(this, "Sunucu Hatası", Toast.LENGTH_LONG).show()
            }

        }



        binding.loginButton.setOnClickListener {
            val email = binding.loginEmailEditText.text.toString().trim()
            val password = binding.loginPasswordEditText.text.toString().trim()

            // todo: input validations
            viewModel.login(email, password)

        }

        binding.signUpTextView.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }


    }


}