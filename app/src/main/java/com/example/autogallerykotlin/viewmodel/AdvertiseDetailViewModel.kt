package com.example.autogallerykotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autogallerykotlin.data.model.AdvertiseDetail

import com.example.autogallerykotlin.data.repository.AdvertiseDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AdvertiseDetailViewModel@Inject constructor(
    private val repository: AdvertiseDetailRepository
) : ViewModel() {

    private val _advertiseDetail = MutableLiveData<Response<AdvertiseDetail>>()
    val advertiseDetail: LiveData<Response<AdvertiseDetail>>
        get() = _advertiseDetail


    fun getAdvertiseDetail(advert_id:String
    ) = viewModelScope.launch {

        _advertiseDetail.postValue(repository.advertiseDetail(
            advert_id
        ))
    }

}