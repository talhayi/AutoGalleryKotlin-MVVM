package com.example.autogallerykotlin.data.model

data class InformationProfile(

    val name: String? = null,
    val surname: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val address: String? = null,
)
data class UpdateProfile(
    val success: Boolean? =null,
    val result: String? =null,
)