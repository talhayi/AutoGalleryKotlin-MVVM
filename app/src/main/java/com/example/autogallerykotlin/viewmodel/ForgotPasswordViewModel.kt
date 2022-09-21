package com.example.autogallerykotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autogallerykotlin.data.model.ForgotPassword
import com.example.autogallerykotlin.data.model.ResetPassword
import com.example.autogallerykotlin.data.repository.ForgotPasswordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val repository: ForgotPasswordRepository
) :ViewModel() {


    private val _forgotPasswordEmail = MutableLiveData<Response<ForgotPassword>>()
 //   val forgotPasswordEmail: LiveData<Response<ForgotPassword>>
    //    get() = _forgotPasswordEmail

    fun forgotPasswordEmail(
        email: String
    ) = viewModelScope.launch {
        _forgotPasswordEmail.postValue(repository.forgotPasswordEmail(email))
    }


    private val _resetPassword = MutableLiveData<Response<ResetPassword>>()
    val resetPassword: LiveData<Response<ResetPassword>>
        get() = _resetPassword

    fun resetPassword(
        email: String,
        password: String
    ) = viewModelScope.launch {
        _resetPassword.postValue(repository.resetPassword(email,password))
    }
}