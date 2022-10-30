package com.example.autogallerykotlin.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddAdvertise(
    val user_id: String? = null,
    val advert_id: String? = null,
    val success: Boolean? = null,

    val result: String? = null,
    val advert_title: String? = null,
    val explanation: String? = null,

    val price: String? = null,
    val address: String? = null,
    val brand: String? = null,

    val serial: String? = null,
    val model: String? = null,
    val year: String? = null,

    val fuel: String? = null,
    val gear: String? = null,
    val vehicleStatus: String? = null,

    val km: String? = null,
    val caseType: String? = null,
    val motorPower: String? = null,

    val motorCapacity: String? = null,
    val traction: String? = null,
    val color: String? = null,

    val guarantee: String? = null,
    val swap: String? = null,
    val phoneNumber: String? = null,


):Parcelable
