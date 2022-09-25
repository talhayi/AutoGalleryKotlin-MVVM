package com.example.autogallerykotlin.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.autogallerykotlin.databinding.ActivityRegisterBinding
import com.example.autogallerykotlin.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.register.observe(this) { registerResponse ->

            if (registerResponse.isSuccessful) {

                if (registerResponse.body()?.tf == true) {

                    val intent = Intent(this, EmailVerificationActivity::class.java)
                    intent.putExtra("email", registerResponse.body()?.email)
                    startActivity(intent)
                    finish()
                    Toast.makeText(this, "Lütfen doğrulama kodunu giriniz", Toast.LENGTH_LONG)
                        .show()
                }
                else {
                    println(registerResponse.body()?.result)
                    Toast.makeText(this, registerResponse.body()?.result, Toast.LENGTH_LONG)
                        .show()
                }
            }
            else {
                Toast.makeText(this, "Sunucu Hatası", Toast.LENGTH_LONG).show()
            }
        }

        binding.registerButton.setOnClickListener {

            //    if (checkForInternet(this)) {

            val name = binding.registerNameEditText.text.toString().trim()
            val surname = binding.registerSurnameEditText.text.toString().trim()
            val email = binding.registerEmailEditText.text.toString().trim()
            val password = binding.registerPasswordEditText.text.toString().trim()

            viewModel.register(name, surname, email, password)
        /*
            } else {
                Toast.makeText(this, "internet bağlantınızı kontrol edin", Toast.LENGTH_SHORT)
                    .show()
            }*/
        }

        binding.signInTextView.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}