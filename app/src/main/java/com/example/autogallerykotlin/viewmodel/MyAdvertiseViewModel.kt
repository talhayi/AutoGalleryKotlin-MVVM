package com.example.autogallerykotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autogallerykotlin.data.model.DeleteMyAdvertise
import com.example.autogallerykotlin.data.model.MyAdvertise
import com.example.autogallerykotlin.data.repository.MyAdvertiseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MyAdvertiseViewModel @Inject constructor(
    private val repository: MyAdvertiseRepository
) : ViewModel() {
    private val _myAdvertise = MutableLiveData<List<MyAdvertise>>()
    val myAdvertise: LiveData<List<MyAdvertise>>
        get() = _myAdvertise
    private val _deleteMyAdvertise = MutableLiveData<Response<DeleteMyAdvertise>>()
    val deleteMyAdvertise: LiveData<Response<DeleteMyAdvertise>>
        get() = _deleteMyAdvertise
    fun getMyAdvertise(
        userId : String
    )=viewModelScope.launch {
        _myAdvertise.postValue(repository.myAdvertise(userId))
    }
    fun getDeleteMyAdvertise(
        advertId: String
    )=viewModelScope.launch {
        _deleteMyAdvertise.postValue(repository.deleteMyAdvertise(advertId))
    }
}