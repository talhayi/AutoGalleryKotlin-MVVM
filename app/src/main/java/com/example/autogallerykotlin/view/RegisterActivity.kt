package com.example.autogallerykotlin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils.isEmpty
import android.text.TextWatcher
import android.util.Patterns
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



        viewModel.register.observe(this) { registerResponse ->

            if (registerResponse.isSuccessful) {


                if (registerResponse.body()?.tf == true) {

                    startActivity(Intent(this, MainActivity::class.java))

                    Toast.makeText(this, registerResponse.body()?.result, Toast.LENGTH_LONG)
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

            val name = binding.registerNameEditText.text.toString().trim()
            val surname = binding.registerSurnameEditText.text.toString().trim()
            val email = binding.registerEmailEditText.text.toString().trim()
            val password = binding.registerPasswordEditText.text.toString().trim()
            viewModel.register(name, surname, email, password)

            if (checkForInternet(this)) {


                if (name.isEmpty() && surname.isEmpty() && email.isEmpty() && password.isEmpty()) {

                    Toast.makeText(this, "Alanları doldurmak zorunludur", Toast.LENGTH_SHORT).show()
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(this, "geçerli mail girin", Toast.LENGTH_SHORT).show()
                } else if (password.length < 6) {
                    Toast.makeText(this, "en az 6 karekter", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "internet bağlantınızı kontrol edin", Toast.LENGTH_SHORT)
                    .show()
            }
        }


    }


}

