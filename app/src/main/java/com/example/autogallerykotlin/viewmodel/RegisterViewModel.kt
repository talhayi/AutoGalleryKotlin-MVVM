package com.example.autogallerykotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autogallerykotlin.model.Login
import com.example.autogallerykotlin.model.Register
import com.example.autogallerykotlin.repository.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: RegisterRepository

) : ViewModel() {

    private val _register = MutableLiveData<Response<Register>>()
    val register: LiveData<Response<Register>>
        get() = _register

    fun register(
        name: String,
        surname: String,
        email: String,
        password: String
    ) = CoroutineScope(Dispatchers.IO).launch {

        _register.postValue(repository.register(name, surname, email, password))
    }
}