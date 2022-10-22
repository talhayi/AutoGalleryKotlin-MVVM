package com.example.autogallerykotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autogallerykotlin.data.model.Advertises
import com.example.autogallerykotlin.data.repository.AdvertisesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AdvertisesViewModel @Inject constructor(
    private val repository: AdvertisesRepository
) : ViewModel(){

    private val _advertises = MutableLiveData<List<Advertises>>()
    val advertises: LiveData<List<Advertises>>
        get() = _advertises


    fun getAdvertises() = viewModelScope.launch {
        _advertises.postValue(repository.advertises())
    }

}