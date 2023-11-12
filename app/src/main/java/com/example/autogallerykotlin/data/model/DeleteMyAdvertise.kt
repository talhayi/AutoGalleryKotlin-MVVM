package com.example.autogallerykotlin.data.model

import com.google.gson.annotations.SerializedName

data class  DeleteMyAdvertise (
    val result: String? = null,
    @SerializedName("advert_id")
    val advertId: String? = null,
    val success: Boolean? = null
)