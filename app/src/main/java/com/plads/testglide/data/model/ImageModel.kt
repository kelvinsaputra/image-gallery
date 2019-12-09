package com.plads.testglide.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageModel (
    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("imageURL")
    @Expose
    var imageUrl: String,

    @SerializedName("imageSize")
    @Expose
    var size: String,

    @SerializedName("imageURL")
    @Expose
    var thumb: String
)