package com.example.autogallerykotlin.view

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.TextUtils.isEmpty
import android.util.Patterns
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.autogallerykotlin.R
import com.example.autogallerykotlin.databinding.ActivityLoginBinding
import com.example.autogallerykotlin.util.Util.checkForInternet
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

                if (loginResponse.body()?.id != null && loginResponse.body()?.email != null) {
                    startActivity(Intent(this, MainActivity::class.java))

                    Toast.makeText(this, "basarili", Toast.LENGTH_LONG).show()
                }

            } else {
                Toast.makeText(this, "Bağlantı hatası", Toast.LENGTH_LONG).show()
            }
        }



        binding.loginButton.setOnClickListener {

            val email = binding.loginEmailEditText.text.toString().trim()
            val password = binding.loginPasswordEditText.text.toString().trim()
            // todo: input validations
            viewModel.login(email, password)

            if (checkForInternet(this)) {
                if (email.isEmpty()) {
                    Toast.makeText(this, "email boş olamaz", Toast.LENGTH_SHORT).show()
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(this, "geçerli mail girin", Toast.LENGTH_SHORT).show()
                } else if (password.isEmpty() || password.length < 6) {
                    Toast.makeText(this, "en az 6 karekter", Toast.LENGTH_SHORT).show()
                } else if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email)
                        .matches() && password.length > 6
                ) {
                    Toast.makeText(this, "Mailiniz veya şifreniz hatalıdır", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(this, "İnternet bağlantınızı kontrol edin", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        binding.signUpTextView.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }

}


/*

*/
