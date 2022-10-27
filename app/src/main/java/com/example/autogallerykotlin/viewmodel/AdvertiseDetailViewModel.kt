package com.example.autogallerykotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autogallerykotlin.data.model.AdvertiseDetail
import com.example.autogallerykotlin.data.model.AdvertiseDetailImage
import com.example.autogallerykotlin.data.model.ChangeFavoriteText

import com.example.autogallerykotlin.data.repository.AdvertiseDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AdvertiseDetailViewModel @Inject constructor(
    private val repository: AdvertiseDetailRepository
) : ViewModel() {

    private val _advertiseDetail = MutableLiveData<Response<AdvertiseDetail>>()
    val advertiseDetail: LiveData<Response<AdvertiseDetail>>
        get() = _advertiseDetail

    private val _advertiseDetailImage = MutableLiveData<List<AdvertiseDetailImage>>()
    val advertiseDetailImage: LiveData<List<AdvertiseDetailImage>>
        get() = _advertiseDetailImage

    private val _changeFavoriteText = MutableLiveData<Response<ChangeFavoriteText>>()
    val changeFavoriteText: LiveData<Response<ChangeFavoriteText>>
        get() = _changeFavoriteText


    fun getAdvertiseDetail(
        advert_id: String
    ) = viewModelScope.launch {

        _advertiseDetail.postValue(
            repository.advertiseDetail(
                advert_id
            )
        )
    }

    fun getAdvertiseDetailImage(
        advert_id: String
    ) = viewModelScope.launch {

        _advertiseDetailImage.postValue(repository.advertiseDetailImage(advert_id))
    }

    fun getChangeFavoriteText(
        user_id: String,
        advert_id: String
    ) = viewModelScope.launch {

        _changeFavoriteText.postValue(repository.changeFavoriteText(user_id, advert_id))
    }
}