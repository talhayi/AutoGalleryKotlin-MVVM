package com.example.autogallerykotlin.data.repository

import com.example.autogallerykotlin.data.service.ApiService
import javax.inject.Inject

class ForgotPasswordRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun forgotPasswordEmail(email: String) = apiService.forgotPasswordEmail(email)

    suspend fun resetPassword(
        email: String,
        password: String
    ) = apiService.resetPassword(email, password)

    suspend fun resetPasswordCode(code: String) = apiService.resetPasswordCode(code)
}
