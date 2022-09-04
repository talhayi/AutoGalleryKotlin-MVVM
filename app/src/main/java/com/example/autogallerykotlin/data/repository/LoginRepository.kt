package com.example.autogallerykotlin.data.repository

import com.example.autogallerykotlin.data.service.ApiService
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun login(
        email: String, password: String
    ) = apiService.login(email, password)


}