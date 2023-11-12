package com.example.autogallerykotlin.data.model

import com.google.gson.annotations.SerializedName

data class Advertises(
    val result: String? = null,
    val image: String? = null,
    @SerializedName("user_id")
    val userId: String? = null,
    @SerializedName("advert_title")
    val advertTitle: String? = null,
    val price: String? = null,
    val address: String? = null,
    val success: Boolean? = null,
    val count: Int? = null,
    val explanation: String? = null,
    @SerializedName("advert_id")
    val advertId: String? = null
)


