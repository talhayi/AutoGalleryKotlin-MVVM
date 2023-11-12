package com.example.autogallerykotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autogallerykotlin.data.model.AdvertiseDetail
import com.example.autogallerykotlin.data.model.AdvertiseDetailImage
import com.example.autogallerykotlin.data.model.ChangeFavoriteText
import com.example.autogallerykotlin.data.model.FavoriteAdvertise

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
    private val _favoriteAdvertise = MutableLiveData<Response<FavoriteAdvertise>>()
    val favoriteAdvertise: LiveData<Response<FavoriteAdvertise>>
        get() = _favoriteAdvertise
    fun getAdvertiseDetail(
        advertId: String
    ) = viewModelScope.launch {
        _advertiseDetail.postValue(
            repository.advertiseDetail(
                advertId
            )
        )
    }
    fun getAdvertiseDetailImage(
        advertId: String
    ) = viewModelScope.launch {
        _advertiseDetailImage.postValue(repository.advertiseDetailImage(advertId))
    }
    fun getChangeFavoriteText(
        userId: String,
        advertId: String
    ) = viewModelScope.launch {
        _changeFavoriteText.postValue(repository.changeFavoriteText(userId, advertId))
    }
    fun getFavoriteAdvertise(
        userId: String,
        advertId: String
    ) = viewModelScope.launch {
        _favoriteAdvertise.postValue(repository.favoriteAdvertise(userId, advertId))
    }
}