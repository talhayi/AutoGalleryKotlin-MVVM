package com.example.autogallerykotlin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.activity.viewModels
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

                if (loginResponse.body()?.id != null && loginResponse.body()?.email != null)
                {
                    startActivity(Intent(this, MainActivity::class.java))

                    Toast.makeText(this, "basarili", Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(this, "Mailiniz veya şifreniz hatalıdır", Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(this, "Sunucu Hatası", Toast.LENGTH_LONG).show()
            }

        }



        binding.loginButton.setOnClickListener {
            val email = binding.loginEmailEditText.text.toString().trim()
            val password = binding.loginPasswordEditText.text.toString().trim()

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Lütfen mail adresinizi girin", Toast.LENGTH_LONG).show()
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Lütfen geçerli bir mail adresi girin", Toast.LENGTH_LONG).show()
            }
            else if (password.length < 6) {
                Toast.makeText(this, "Şifreniz en az 6 karekter olmalıdır", Toast.LENGTH_LONG).show()
            }


            // todo: input validations
            viewModel.login(email, password)

        }

        binding.signUpTextView.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }


    }


}