package com.example.autogallerykotlin.data.repository

import com.example.autogallerykotlin.data.service.ApiService
import javax.inject.Inject

class AddAdvertiseImageRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun addAdvertiseImage(
        user_id:String,
        advert_id:String,
        image:String

    )=apiService.addAdvertiseImage(
        user_id, advert_id,image
    )
}