package com.example.autogallerykotlin.service

import androidx.lifecycle.LiveData
import com.example.autogallerykotlin.model.Login
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("login.php")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<Login>

}