package com.example.autogallerykotlin.data.repository

import com.example.autogallerykotlin.data.model.AdvertiseDetail
import com.example.autogallerykotlin.data.service.ApiService
import retrofit2.Response
import javax.inject.Inject

class AdvertiseDetailRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun advertiseDetail(
        advert_id: String
    ):Response<AdvertiseDetail>{
        return apiService.advertiseDetail(
            advert_id
        )
    }
}