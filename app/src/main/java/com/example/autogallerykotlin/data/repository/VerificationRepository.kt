package com.example.autogallerykotlin.data.repository

import com.example.autogallerykotlin.data.service.ApiService
import javax.inject.Inject

class VerificationRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun verification(
      //  email: String,
        code: String
    ) = apiService.verification(code)

}