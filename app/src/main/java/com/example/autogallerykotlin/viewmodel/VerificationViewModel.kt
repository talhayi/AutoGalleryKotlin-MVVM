package com.example.autogallerykotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autogallerykotlin.data.model.Verification
import com.example.autogallerykotlin.data.repository.VerificationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class VerificationViewModel @Inject constructor(
    private val repository: VerificationRepository
): ViewModel() {


    private val _verification = MutableLiveData<Response<Verification>>()
    val verification: LiveData<Response<Verification>>
        get() = _verification


    fun verification(
     //   email: String,
        code: String
    ) = viewModelScope.launch {
        _verification.postValue(repository.verification(code))

    }
}