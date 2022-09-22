package com.example.autogallerykotlin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.autogallerykotlin.data.model.resetPasswordCode
import com.example.autogallerykotlin.databinding.ActivityForgotPasswordBinding
import com.example.autogallerykotlin.viewmodel.ForgotPasswordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding
    private val viewModel: ForgotPasswordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            forgotPasswordEmailButton.setOnClickListener {

                if(forgotPasswordEditText.text.toString() != ""){

                    forgotPasswordEditText.visibility = View.GONE
                    forgotPasswordEmailButton.visibility = View.GONE
                    forgotPasswordtextView.visibility = View.GONE
                    forgotPasswordCodeEditText.visibility = View.VISIBLE
                    forgotPasswordCodeButton.visibility = View.VISIBLE
                    forgotPasswordCodetextView.visibility = View.VISIBLE

                    val email = binding.forgotPasswordEditText.text.toString().trim()

                    viewModel.forgotPasswordEmail(email)
                }
                else{
                    Toast.makeText(applicationContext, "Lütfen email adresinizi girin", Toast.LENGTH_SHORT).show()
                }



            }
        }



        binding.apply {
            forgotPasswordCodeButton.setOnClickListener {

                if (forgotPasswordCodeEditText.text.toString() !=""){
                    forgotPasswordCodeEditText.visibility = View.GONE
                    forgotPasswordCodeButton.visibility = View.GONE
                    forgotPasswordCodetextView.visibility = View.GONE
                    newPasswordEditText.visibility = View.VISIBLE
                    newPasswordButton.visibility = View.VISIBLE
                    newPasswordtextView.visibility = View.VISIBLE
                    val code = forgotPasswordCodeEditText.text.toString()
                    viewModel.resetPasswordCode(code)
                }
                else{
                    Toast.makeText(applicationContext, "Lütfen doğrulama kodunu girin", Toast.LENGTH_SHORT).show()
                }


            }
        }

        viewModel.resetPasswordCode.observe(this){resetPasswordCodeResponse->

            if(resetPasswordCodeResponse.isSuccessful){
                if (resetPasswordCodeResponse.body()?.success == true){
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                else{
                    Toast.makeText(this, resetPasswordCodeResponse.body()?.result, Toast.LENGTH_SHORT).show()
                }
            }

        }

        binding.apply {
            newPasswordButton.setOnClickListener {
                val email = binding.forgotPasswordEditText.text.toString().trim()
                val password = binding.newPasswordEditText.text.toString().trim()
                viewModel.resetPassword(email, password)
            }
        }

        viewModel.resetPassword.observe(this){resetPasswordResponse->

            if(resetPasswordResponse.isSuccessful){
                if (resetPasswordResponse.body()?.success == true){
                    startActivity(Intent(this, MainActivity::class.java))
                    Toast.makeText(this, "Şifreniz yenilendi", Toast.LENGTH_SHORT).show()
                    finish()
                }
                else{
                    Toast.makeText(this, resetPasswordResponse.body()?.result, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}