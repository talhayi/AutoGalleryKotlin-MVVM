package com.example.autogallerykotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
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
/*
        viewModel.forgotPasswordEmail.observe(this){forgotPasswordEmailResponse->

            if (forgotPasswordEmailResponse.isSuccessful){

                //Toast.makeText(this, forgotPasswordEmailResponse.body()?.result, Toast.LENGTH_SHORT).show()

                if (forgotPasswordEmailResponse.body()?.success == true){

                   // Toast.makeText(this, forgotPasswordEmailResponse.body()?.result, Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, forgotPasswordEmailResponse.body()?.result, Toast.LENGTH_SHORT).show()
                }
            }
        }
*/
        binding.apply {
            forgotPasswordEmailButton.setOnClickListener {

                forgotPasswordEditText.visibility = View.GONE
                forgotPasswordEmailButton.visibility = View.GONE
                forgotPasswordtextView.visibility = View.GONE
                forgotPasswordCodeEditText.visibility = View.VISIBLE
                forgotPasswordCodeButton.visibility = View.VISIBLE
                forgotPasswordCodetextView.visibility = View.VISIBLE

                val email = binding.forgotPasswordEditText.text.toString().trim()
                viewModel.forgotPasswordEmail(email)

            }
        }

        binding.apply {
            forgotPasswordCodeButton.setOnClickListener {

                forgotPasswordCodeEditText.visibility = View.GONE
                forgotPasswordCodeButton.visibility = View.GONE
                forgotPasswordCodetextView.visibility = View.GONE
                newPasswordEditText.visibility = View.VISIBLE
                newPasswordButton.visibility = View.VISIBLE
                newPasswordtextView.visibility = View.VISIBLE
            }
        }
    }
}