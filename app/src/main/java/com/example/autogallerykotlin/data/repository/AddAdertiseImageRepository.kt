package com.example.autogallerykotlin.data.repository

import com.example.autogallerykotlin.data.service.ApiService
import javax.inject.Inject

class AddAdvertiseImageRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun addAdvertiseImage(
        userId:String,
        advertId:String,
        image:String

    )=apiService.addAdvertiseImage(
        userId, advertId,image
    )
}