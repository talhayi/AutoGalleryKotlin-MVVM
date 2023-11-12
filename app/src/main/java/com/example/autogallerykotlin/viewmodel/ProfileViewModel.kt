package com.example.autogallerykotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autogallerykotlin.data.model.InformationProfile
import com.example.autogallerykotlin.data.model.UpdateProfile
import com.example.autogallerykotlin.data.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel@Inject constructor(
    private val repository: ProfileRepository
) : ViewModel() {
    private val _informationProfile = MutableLiveData<Response<InformationProfile>>()
    val informationProfile: LiveData<Response<InformationProfile>>
        get() = _informationProfile
    private val _updateProfileEmail = MutableLiveData<Response<UpdateProfile>>()
    val updateProfileEmail: LiveData<Response<UpdateProfile>>
        get() = _updateProfileEmail

    private val _updateProfilePassword = MutableLiveData<Response<UpdateProfile>>()
    val updateProfilePassword: LiveData<Response<UpdateProfile>>
        get() = _updateProfilePassword

    private val _updateProfilePhone = MutableLiveData<Response<UpdateProfile>>()
    val updateProfilePhone: LiveData<Response<UpdateProfile>>
        get() = _updateProfilePhone
    fun getInformationProfile(
        user_id : String
    )=viewModelScope.launch {
        _informationProfile.postValue(repository.informationProfile(user_id))
    }
    fun getUpdateProfileEmail(
        user_id : String,
        email : String,
       /* password : String,
        againPassword : String,
        phoneNumber : String,
        city : String,
        district : String,
        neighborhood : String,*/
    )=viewModelScope.launch {
        _updateProfileEmail.postValue(repository.updateProfileEmail(
            user_id,
            email,
           /* password,
            againPassword,
            phoneNumber,
            city,
            district,
            neighborhood,*/
        ))
    }

    fun getUpdateProfilePassword(
        user_id: String,
        password: String,
        againPassword: String,
        ) = viewModelScope.launch {
        _updateProfilePassword.postValue(
            repository.updateProfilePassword(
                user_id,
                password,
                againPassword
            )
        )
    }

    fun getUpdateProfilePhone(
        user_id: String,
        phoneNumber : String,
    ) = viewModelScope.launch {
        _updateProfilePhone.postValue(
            repository.updateProfilePhone(
                user_id,
                phoneNumber
            )
        )
    }
}