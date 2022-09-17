package com.example.autogallerykotlin.viewmodel


import androidx.lifecycle.*
import com.example.autogallerykotlin.data.model.Register
import com.example.autogallerykotlin.data.model.Verification
import com.example.autogallerykotlin.data.repository.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


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


