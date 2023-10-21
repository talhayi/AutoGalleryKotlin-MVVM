package com.example.autogallerykotlin.data.repository

import com.example.autogallerykotlin.data.model.AdvertiseDetailImage
import com.example.autogallerykotlin.data.model.Advertises
import com.example.autogallerykotlin.data.service.ApiService
import retrofit2.Response
import javax.inject.Inject

class AdvertisesRepository@Inject constructor(
    private val apiService: ApiService
) {
    suspend fun advertises():List<Advertises>{
        return apiService.advertises()
    }
}