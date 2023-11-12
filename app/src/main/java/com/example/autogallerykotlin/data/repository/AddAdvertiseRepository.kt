package com.example.autogallerykotlin.data.repository

import com.example.autogallerykotlin.data.service.ApiService
import javax.inject.Inject

class AddAdvertiseRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun addAdvertise(
        userId: String, advertTitle: String, explanation: String,
        price: String, address: String, brand: String,
        serial: String, model: String, year: String,
        fuel: String, gear: String, vehicleStatus: String,
        km: String, caseType: String, motorPower: String,
        motorCapacity: String, traction: String, color: String,
        guarantee: String, swap: String, phoneNumber: String

    ) = apiService.addAdvertise(
        userId,advertTitle,explanation,
        price,address,brand,
        serial,model,year,
        fuel,gear,vehicleStatus,
        km,caseType,motorPower,
        motorCapacity,traction,color,
        guarantee,swap,phoneNumber
    )
}
