package com.example.autogallerykotlin.view

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.autogallerykotlin.R
import com.example.autogallerykotlin.databinding.ActivityForgotPasswordBinding
import com.example.autogallerykotlin.databinding.ActivityLoginBinding
import com.example.autogallerykotlin.viewmodel.ForgotPasswordViewModel
import com.example.autogallerykotlin.viewmodel.LoginViewModel

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding
    private val viewModel: ForgotPasswordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.forgotPasswordEmailButton.setOnClickListener {
            binding.forgotPasswordEditText.visibility = View.GONE
            binding.forgotPasswordEmailButton.visibility = View.GONE
            binding.forgotPasswordtextView.visibility = View.GONE
            binding.forgotPasswordCodeEditText.visibility = View.VISIBLE
            binding.forgotPasswordCodeButton.visibility = View.VISIBLE
            binding.forgotPasswordCodetextView.visibility = View.VISIBLE
        }

        binding.forgotPasswordCodeButton.setOnClickListener {

            binding.forgotPasswordCodeEditText.visibility = View.GONE
            binding.forgotPasswordCodeButton.visibility = View.GONE
            binding.forgotPasswordCodetextView.visibility = View.GONE
            binding.newPasswordEditText.visibility = View.VISIBLE
            binding.newPasswordButton.visibility = View.VISIBLE
            binding.newPasswordtextView.visibility = View.VISIBLE
        }

    }
}