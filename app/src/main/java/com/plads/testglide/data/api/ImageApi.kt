package com.plads.testglide.data.api

import com.plads.testglide.data.model.PixabayResponse
import retrofit2.http.GET

interface ImageApi {
    @GET("?key=1152002-28faf189e53595474e698ee85&q=yellow+flowers&image_type=photo")
    suspend fun getImages(): PixabayResponse
}