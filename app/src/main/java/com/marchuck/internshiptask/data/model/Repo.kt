package com.marchuck.internshiptask.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Repo(
    @SerializedName("name") val name: String
    , @SerializedName("owner") val owner: Owner
    , @SerializedName("stargazers_count") val stargazers_count: Int
    , @SerializedName("forks") val forks: Int
    , @SerializedName("watchers_count") val watchers_count: Int
    , @SerializedName("language") val language: String?
    , @SerializedName("license") val license: License?
): Serializable