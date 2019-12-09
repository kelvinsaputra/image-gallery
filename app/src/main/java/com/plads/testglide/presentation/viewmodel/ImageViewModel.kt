package com.plads.testglide.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plads.testglide.data.model.ImageModel
import com.plads.testglide.domain.GetImagesUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImageViewModel: ViewModel() {
    private val getImages = GetImagesUsecase()
    val images = MutableLiveData<List<ImageModel>>()

    fun getImages(){
        viewModelScope.launch(Dispatchers.IO) {
            images.postValue(getImages.getImages())
        }
    }
}