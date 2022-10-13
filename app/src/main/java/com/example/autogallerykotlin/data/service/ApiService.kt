package com.example.autogallerykotlin.data.service


import com.example.autogallerykotlin.data.model.*
import retrofit2.Call
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
    ): Response<ResetPasswordCode>

    @FormUrlEncoded
    @POST("advertise.php")
    suspend fun addAdvertise(
        @Field("user_id") user_id: String, @Field("advert_title") advert_title: String, @Field("explanation") explanation: String,
        @Field("price") price: String, @Field("address") address: String, @Field("brand") brand: String,
        @Field("serial") serial: String, @Field("model") model: String, @Field("year") year: String,
        @Field("fuel") fuel: String, @Field("gear") gear: String, @Field("vehicleStatus") vehicleStatus: String,
        @Field("km") km: String, @Field("caseType") caseType: String, @Field("motorPower") motorPower: String,
        @Field("motorCapacity") motorCapacity: String, @Field("traction") traction: String, @Field("color") color: String,
        @Field("guarantee") guarantee: String, @Field("swap") swap: String, @Field("phoneNumber") phoneNumber: String
    ): Response<AddAdvertise>

    @FormUrlEncoded
    @POST("addAdvertiseImage.php")
    suspend fun addAdvertiseImage(
        @Field("user_id") user_id: String?,
        @Field("advert_id") advert_id: String?,
        @Field("image") image: String?
    ):Response<AddAdvertiseImage>

    @GET("myAdvertise.php")
    suspend fun myAdvertise(@Query("user_id") user_id: String?): Response<List<MyAdvertise?>?>

}




















