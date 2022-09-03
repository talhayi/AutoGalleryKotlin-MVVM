package com.example.autogallerykotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.autogallerykotlin.R
import com.example.autogallerykotlin.databinding.ActivityLoginBinding
import com.example.autogallerykotlin.databinding.ActivityRegisterBinding
import dagger.hilt.android.AndroidEntryPoint


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}