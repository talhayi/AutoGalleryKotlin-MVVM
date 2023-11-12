package com.example.autogallerykotlin.data.repository

import com.example.autogallerykotlin.data.model.MyFavoriteAdvertise

import com.example.autogallerykotlin.data.service.ApiService
import javax.inject.Inject

class MyFavoriteRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun myFavoriteAdvertise(
        userId: String
    ): List<MyFavoriteAdvertise> {
       return apiService.myFavoriteAdvertise(userId)
    }
}