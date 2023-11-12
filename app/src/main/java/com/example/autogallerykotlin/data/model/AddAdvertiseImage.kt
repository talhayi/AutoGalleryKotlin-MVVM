package com.example.autogallerykotlin.data.model

import com.google.gson.annotations.SerializedName

data class AddAdvertiseImage(
    @SerializedName("user_id")
    val userId: String? = null,
    @SerializedName("advert_id")
    val advertId: String? = null,
    val success: Boolean? = null,
    val result: String? = null
)
