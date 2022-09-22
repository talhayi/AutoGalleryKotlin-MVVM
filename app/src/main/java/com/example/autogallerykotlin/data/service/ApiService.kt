package com.example.autogallerykotlin.data.service


import com.example.autogallerykotlin.data.model.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("login.php")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<Login>

    @FormUrlEncoded
    @POST("register.php")
    suspend fun register(
        @Field("name") name: String,
        @Field("surname") surname: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<Register>

    @FormUrlEncoded
    @POST("verification.php")
    suspend fun emailVerification(
        @Field("email") email: String,
        @Field("code") code: String
    ): Response<EmailVerification>

    @FormUrlEncoded
    @POST("forgotPasswordEmail.php")
    suspend fun forgotPasswordEmail(
        @Field("email") email: String
    ): Response<ForgotPassword>

    @FormUrlEncoded
    @POST("resetPassword.php")
    suspend fun resetPassword(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<ResetPassword>

    @FormUrlEncoded
    @POST("resetPasswordCode.php")
    suspend fun resetPasswordCode(
        @Field("code") code: String
    ): Response<resetPasswordCode>
}
