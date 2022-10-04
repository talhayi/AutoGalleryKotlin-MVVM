package com.example.autogallerykotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autogallerykotlin.data.model.AddAdvertise
import com.example.autogallerykotlin.data.model.AddAdvertiseResult
import com.example.autogallerykotlin.data.repository.AddAdvertiseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AddAdvertiseViewModel @Inject constructor(
    private val repository: AddAdvertiseRepository
) : ViewModel() {

    private val _addAdvertise = MutableLiveData<Response<AddAdvertise>>()
    val addAdvertise: LiveData<Response<AddAdvertise>>
    get() = _addAdvertise


    private val _addAdvertiseResult = MutableLiveData<Response<AddAdvertiseResult>>()
    val addAdvertiseResult: LiveData<Response<AddAdvertiseResult>>
        get() = _addAdvertiseResult


    fun addAdvertise(

        user_id: String, advert_title: String, explanation: String,
        price: String, address: String, brand: String,
        serial: String, model: String, year: String,
        fuel: String, gear: String, vehicleStatus: String,
        km: String, caseType: String, motorPower: String,
        motorCapacity: String, traction: String, color: String,
        guarantee: String, swap: String, phoneNumber: String

    ) = viewModelScope.launch {

        _addAdvertise.postValue(repository.addAdvertise(
            user_id,advert_title,explanation,
            price,address,brand,
            serial,model,year,
            fuel,gear,vehicleStatus,
            km,caseType,motorPower,
            motorCapacity,traction,color,
            guarantee,swap,phoneNumber
        ))
    }
}