package com.example.autogallerykotlin.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val sharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        if (sharedPreferences.getString("users_id",null) != null && sharedPreferences.getString("users_email", null) != null){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        viewModel.login.observe(this) { loginResponse ->

            if (loginResponse.isSuccessful) {

                if (loginResponse.body()?.id != null && loginResponse.body()?.email != null) {

                    editor.putString("users_id", loginResponse.body()?.id.toString())
                    editor.putString("users_email", loginResponse.body()?.email.toString())
                    editor.apply()
                    editor.clear()

                    startActivity(Intent(this, MainActivity::class.java))
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    finish()

                }
                else {
                    Toast.makeText(this, loginResponse.body()?.result, Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this, "Bağlantı hatası", Toast.LENGTH_LONG).show()
            }
        }

        binding.loginButton.setOnClickListener {

            val email = binding.loginEmailEditText.text.toString().trim()
            val password = binding.loginPasswordEditText.text.toString().trim()

            viewModel.login(email, password)


                   /*
            if (checkForInternet(this)) {

            } else {
                Toast.makeText(this, "İnternet bağlantınızı kontrol edin", Toast.LENGTH_SHORT)
                    .show()
            }   */

        }

        binding.signUpTextView.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }

        binding.loginForgetPasswordTextView.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
            finish()
        }
    }
}