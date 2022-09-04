package com.example.autogallerykotlin.repository

import com.example.autogallerykotlin.service.ApiService
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun login(
        email: String, password: String
    ) = apiService.login(email, password)


}