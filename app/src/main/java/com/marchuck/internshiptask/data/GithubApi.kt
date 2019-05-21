package com.marchuck.internshiptask.data

import com.marchuck.internshiptask.data.model.ReposResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubApi {

    companion object {
        const val GITHUB_BASE_URL = "https://api.github.com/"
    }

    @GET("users/{name}/repos")
    fun getUserRepos(@Path("name") userName: String): Deferred<ReposResponse>

}