package com.example.autogallerykotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autogallerykotlin.data.model.MyFavoriteAdvertise
import com.example.autogallerykotlin.data.repository.MyFavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyFavoriteAdvertiseViewModel @Inject constructor(
    private val repository:MyFavoriteRepository
) : ViewModel() {
    private val _myFavoriteAdvertise = MutableLiveData<List<MyFavoriteAdvertise>>()
    val myFavoriteAdvertise: LiveData<List<MyFavoriteAdvertise>>
        get() = _myFavoriteAdvertise
    fun getMyFavoriteAdvertise(
        userId : String
    )=viewModelScope.launch {
        _myFavoriteAdvertise.postValue(repository.myFavoriteAdvertise(userId))
    }
}