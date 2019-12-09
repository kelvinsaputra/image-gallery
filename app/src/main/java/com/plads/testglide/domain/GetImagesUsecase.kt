package com.plads.testglide.domain

import com.plads.testglide.data.model.ImageModel
import com.plads.testglide.data.repository.ImageRepository

class GetImagesUsecase{
    private val imageRepository = ImageRepository()

    suspend fun getImages(): List<ImageModel>{
        return imageRepository.getImages()
    }
}