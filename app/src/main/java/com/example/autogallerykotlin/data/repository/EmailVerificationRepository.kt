package com.example.autogallerykotlin.data.repository

import com.example.autogallerykotlin.data.service.ApiService
import javax.inject.Inject

class EmailVerificationRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun emailVerification(
        email: String,
        code: String
    ) = apiService.emailVerification(email,code)
}
