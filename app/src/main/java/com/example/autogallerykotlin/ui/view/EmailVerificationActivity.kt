package com.example.autogallerykotlin.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.autogallerykotlin.databinding.ActivityEmailVerificationBinding
import com.example.autogallerykotlin.util.Util
import com.example.autogallerykotlin.viewmodel.EmailVerificationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmailVerificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmailVerificationBinding
    private val viewModel: EmailVerificationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        viewModel.emailVerification.observe(this) { emailVerificationResponse ->
            if (emailVerificationResponse.isSuccessful) {
                if (emailVerificationResponse.body()?.tf == true) {
                    editor.putString("users_id", emailVerificationResponse.body()?.id.toString())
                    editor.putString("users_email", emailVerificationResponse.body()?.email.toString())
                    editor.apply()
                    startActivity(Intent(this, MainActivity::class.java))
                    Toast.makeText(this, "Email adresiniz doğrulandı", Toast.LENGTH_SHORT).show()
                    finish()
                }
                else {
                    Toast.makeText(this, "Email adresiniz doğrulanmadı", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.registerLoginButton.setOnClickListener {
            if (Util.checkForInternet(this)) {
                val i = intent
                val email = i.getStringExtra("email").toString()
                val code = binding.verificationCodeEditText.text.toString().trim()
                viewModel.emailVerification(email, code)
            } else {
                Toast.makeText(this, "internet bağlantınızı kontrol edin", Toast.LENGTH_SHORT).show()
            }
        }
    }
}