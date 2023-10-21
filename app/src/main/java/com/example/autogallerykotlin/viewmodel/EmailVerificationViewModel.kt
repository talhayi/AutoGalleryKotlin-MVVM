package com.example.autogallerykotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autogallerykotlin.data.model.EmailVerification
import com.example.autogallerykotlin.data.repository.EmailVerificationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class EmailVerificationViewModel @Inject constructor(
    private val repository: EmailVerificationRepository
): ViewModel() {
    private val _emailVerification = MutableLiveData<Response<EmailVerification>>()
    val emailVerification: LiveData<Response<EmailVerification>>
        get() = _emailVerification
    fun emailVerification(
        email: String,
        code: String
    ) = viewModelScope.launch {
        _emailVerification.postValue(repository.emailVerification(email,code))
    }
}