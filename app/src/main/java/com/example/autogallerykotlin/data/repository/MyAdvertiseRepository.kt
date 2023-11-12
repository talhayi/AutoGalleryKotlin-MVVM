package com.example.autogallerykotlin.data.repository

import com.example.autogallerykotlin.data.model.MyAdvertise

import com.example.autogallerykotlin.data.service.ApiService
import javax.inject.Inject

class MyAdvertiseRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun myAdvertise(
        userId: String
    ): List<MyAdvertise>? {
       return apiService.myAdvertise(userId)
    }
    suspend fun deleteMyAdvertise(advertId:String)
            =apiService.deleteMyAdvertise(advertId)
}