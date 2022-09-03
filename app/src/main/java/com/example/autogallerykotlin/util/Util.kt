package com.example.autogallerykotlin.util

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object Util {
    const val BASE_URL = "http://yazilimgunlukleri.com/autogallerykotlin/"

    private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
}