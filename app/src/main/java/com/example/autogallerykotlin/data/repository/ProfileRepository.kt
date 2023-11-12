package com.example.autogallerykotlin.data.repository

import com.example.autogallerykotlin.data.model.InformationProfile
import com.example.autogallerykotlin.data.model.UpdateProfile
import com.example.autogallerykotlin.data.service.ApiService
import retrofit2.Response
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun informationProfile(
        userId: String
    ): Response<InformationProfile> {
        return apiService.informationProfile(userId)
    }
    suspend fun updateProfileEmail(
        userId: String,
        email: String,
    ): Response<UpdateProfile> {
        return apiService.updateProfileEmail(
            userId,
            email,
        )
    }

    suspend fun updateProfilePassword(
        userId: String,
        password: String,
        againPassword: String,
        ): Response<UpdateProfile> {
        return apiService.updateProfilePassword(
            userId,
            password,
            againPassword,

            )
    }

    suspend fun updateProfilePhone(
        userId: String,
        phoneNumber: String,
    ): Response<UpdateProfile> {
        return apiService.updateProfilePhone(
            userId,
            phoneNumber
            )
    }

    suspend fun updateProfileAddress(
        userId: String,
        city: String,
        district: String,
        neighborhood: String,
    ): Response<UpdateProfile> {
        return apiService.updateProfileAddress(
            userId,
            city,
            district,
            neighborhood,
        )
    }
}