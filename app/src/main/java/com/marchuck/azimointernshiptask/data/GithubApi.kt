package com.marchuck.azimointernshiptask.data

import com.marchuck.azimointernshiptask.data.model.ReposResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubApi {

    companion object {
        const val GITHUB_BASE_URL = "https://api.github.com/"
    }

    //@Headers("Accept: application/vnd.github.v3+json")
    @GET("users/{name}/repos")
    fun getUserRepos(@Path("name") userName: String): Deferred<ReposResponse>

}