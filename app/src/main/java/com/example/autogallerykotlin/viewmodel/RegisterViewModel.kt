package com.example.autogallerykotlin.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.autogallerykotlin.model.Register
import com.example.autogallerykotlin.repository.RegisterRepository
import com.example.autogallerykotlin.util.Util.checkForInternet
import dagger.hilt.android.lifecycle.HiltViewModel
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
    ) = viewModelScope.launch {

            _register.postValue(repository.register(name, surname, email, password))

        }
    }


