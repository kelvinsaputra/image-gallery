package com.plads.testglide.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PixabayResponse (
    @SerializedName("totalHits")
    @Expose
    var totalHits: Int,

    @SerializedName("hits")
    @Expose
    var hits: List<ImageModel>,

    @SerializedName("total")
    @Expose
    var total: Int
)