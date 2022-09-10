package com.example.autogallerykotlin.view

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils.isEmpty
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.activity.viewModels
import com.example.autogallerykotlin.databinding.ActivityRegisterBinding
import com.example.autogallerykotlin.util.Util.checkForInternet
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


        val sharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        viewModel.register.observe(this) { registerResponse ->

            if (registerResponse.isSuccessful) {


                if (registerResponse.body()?.tf == true) {
                    binding.registerNameEditText.visibility = GONE
                    binding.registerSurnameEditText.visibility = GONE
                    binding.registerEmailEditText.visibility = GONE
                    binding.registerPasswordEditText.visibility = GONE
                    binding.registerButton.visibility = GONE
                    binding.registerLoginButton.visibility = VISIBLE
                    binding.verificationCodeEditText.visibility = VISIBLE

                   // startActivity(Intent(this, MainActivity::class.java))

                    Toast.makeText(this, "Lütfen doğrulama kodunu giriniz", Toast.LENGTH_LONG)
                        .show()

                } else {

                    Toast.makeText(this, registerResponse.body()?.result, Toast.LENGTH_LONG)
                        .show()
                }


            } else {
                Toast.makeText(this, "Sunucu Hatası", Toast.LENGTH_LONG).show()

            }

        }

        binding.registerButton.setOnClickListener {

            if (checkForInternet(this)) {


                val name = binding.registerNameEditText.text.toString().trim()
                val surname = binding.registerSurnameEditText.text.toString().trim()
                val email = binding.registerEmailEditText.text.toString().trim()
                val password = binding.registerPasswordEditText.text.toString().trim()

                viewModel.register(name, surname, email, password)

            } else {
                Toast.makeText(this, "internet bağlantınızı kontrol edin", Toast.LENGTH_SHORT)
                    .show()
            }
        }


        viewModel.verification.observe(this){verificationResponce->

            if (verificationResponce.isSuccessful){

                if (verificationResponce.body()?.tf ==true){
                    editor.putString("users_id", verificationResponce.body()?.id.toString())
                    editor.putString("users_email", verificationResponce.body()?.email.toString())
                    editor.apply()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }

            }
        }

        binding.registerLoginButton.setOnClickListener {
            if (checkForInternet(this)) {

                val email = binding.registerEmailEditText.text.toString().trim()
                val code = binding.verificationCodeEditText.text.toString().trim()

                viewModel.verification(email,code)

            } else {
                Toast.makeText(this, "internet bağlantınızı kontrol edin", Toast.LENGTH_SHORT)
                    .show()
            }
        }



    }


}

