package com.example.autogallerykotlin.data.repository

import com.example.autogallerykotlin.data.model.AdvertiseDetail
import com.example.autogallerykotlin.data.model.AdvertiseDetailImage
import com.example.autogallerykotlin.data.model.ChangeFavoriteText
import com.example.autogallerykotlin.data.model.FavoriteAdvertise
import com.example.autogallerykotlin.data.service.ApiService
import retrofit2.Response
import javax.inject.Inject

class AdvertiseDetailRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun advertiseDetail(
        advertId: String
    ): Response<AdvertiseDetail> {
        return apiService.advertiseDetail(
            advertId
        )
    }
    suspend fun advertiseDetailImage(
        advertId: String
    ): List<AdvertiseDetailImage> {
        return apiService.advertiseDetailImage(advertId)
    }
    suspend fun changeFavoriteText(
        userId:String,
        advertId: String
    ): Response<ChangeFavoriteText> {
        return apiService.changeFavoriteText(
            userId,advertId
        )
    }
    suspend fun favoriteAdvertise(
        userId:String,
        advertId: String
    ): Response<FavoriteAdvertise> {
        return apiService.favoriteAdvertise(
            userId,advertId
        )
    }
}