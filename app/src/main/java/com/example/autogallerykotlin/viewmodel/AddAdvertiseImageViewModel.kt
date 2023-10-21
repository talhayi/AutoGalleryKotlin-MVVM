package com.example.autogallerykotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autogallerykotlin.data.model.AddAdvertise
import com.example.autogallerykotlin.data.model.AddAdvertiseImage
import com.example.autogallerykotlin.data.repository.AddAdvertiseImageRepository
import com.example.autogallerykotlin.data.repository.AddAdvertiseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AddAdvertiseImageViewModel @Inject constructor(
    private val repository: AddAdvertiseImageRepository
) : ViewModel() {
    private val _addAdvertiseImage = MutableLiveData<Response<AddAdvertiseImage>>()
    val addAdvertiseImage: LiveData<Response<AddAdvertiseImage>>
        get() = _addAdvertiseImage
    fun addAdvertiseImage(
        user_id:String,
        advert_id:String,
        image:String
    )=viewModelScope.launch {
        _addAdvertiseImage.postValue(repository.addAdvertiseImage(
            user_id,advert_id,image))
    }
}