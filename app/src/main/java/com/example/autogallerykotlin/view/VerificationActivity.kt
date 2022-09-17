package com.example.autogallerykotlin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.autogallerykotlin.databinding.ActivityVerificationBinding
import com.example.autogallerykotlin.util.Util
import com.example.autogallerykotlin.viewmodel.VerificationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VerificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVerificationBinding
    private val viewModel: VerificationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        viewModel.verification.observe(this){verificationResponse->

            if (verificationResponse.isSuccessful){

                if (verificationResponse.body()?.tf ==true){
                    editor.putString("users_id", verificationResponse.body()?.id.toString())
                    editor.putString("users_email", verificationResponse.body()?.email.toString())
                    editor.apply()
                    startActivity(Intent(this, MainActivity::class.java))
                    Toast.makeText(this, "Email adresiniz doğrulandı", Toast.LENGTH_SHORT).show()
                    finish()
                }else{
                    Toast.makeText(this, "Email adresiniz doğrulanmadı", Toast.LENGTH_SHORT).show()
                }

            }
        }



        binding.registerLoginButton.setOnClickListener {
            if (Util.checkForInternet(this)) {

            //    val email = binding.registerEmailEditText.text.toString().trim()
                val code = binding.verificationCodeEditText.text.toString().trim()

                viewModel.verification(code)

            } else {
                Toast.makeText(this, "internet bağlantınızı kontrol edin", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }
}