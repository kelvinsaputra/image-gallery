package com.plads.testglide.data.repository

import com.plads.testglide.data.api.ImageApi
import com.plads.testglide.data.model.ImageModel
import com.plads.testglide.data.model.PixabayResponse
import com.plads.testglide.utils.RetrofitNetwork

class ImageRepository {
    private var imageList : List<ImageModel> = listOf()
    private lateinit var pixabayResponse: PixabayResponse
    private var retrofit = RetrofitNetwork().getClient()

    suspend fun getImages(): List<ImageModel>{
        pixabayResponse = retrofit.create(ImageApi::class.java).getImages()
        imageList = pixabayResponse.hits

        return imageList
    }
}