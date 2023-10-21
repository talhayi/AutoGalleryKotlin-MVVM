package com.example.autogallerykotlin.data.model

data class InformationProfile(

    val name: String? = null,
    val surname: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val address: String? = null,
)
data class UpdateProfile(

    val emailSuccess: Boolean? =null,
    val email: String? = null,
    val result: String? =null,
    /*
    val passwordSuccess: Boolean? =null,
    val phoneNumberSuccess: Boolean? =null,
    val addressSuccess: Boolean? =null,
    val phoneNumber: String? = null,
    val address: String? = null,*/
)