package com.example.autogallerykotlin.repository

import com.example.autogallerykotlin.service.ApiService
import javax.inject.Inject

class RegisterRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun register(
        name: String,
        surname: String,
        email:String,
        password:String
    )= apiService.register(name, surname, email, password)
}