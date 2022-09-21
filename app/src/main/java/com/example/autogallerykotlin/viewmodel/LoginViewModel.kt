package com.example.autogallerykotlin.viewmodel

import androidx.lifecycle.*
import com.example.autogallerykotlin.data.model.Login
import com.example.autogallerykotlin.data.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(

    private val repository: LoginRepository,

    ) : ViewModel() {

    private val _login = MutableLiveData<Response<Login>>()
    val login: LiveData<Response<Login>>
        get() = _login

    fun login(
        email: String,
        password: String
    ) = viewModelScope.launch {
        _login.postValue(repository.login(email, password))
    }
}