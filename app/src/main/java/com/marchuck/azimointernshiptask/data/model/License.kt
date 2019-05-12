package com.marchuck.azimointernshiptask.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class License(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
):Serializable