package com.marchuck.internshiptask.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.marchuck.internshiptask.data.GithubApi.Companion.GITHUB_BASE_URL
import com.marchuck.internshiptask.data.model.ReposResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class GithubClient : GithubApi {

    private val timeoutInSeconds = 10L

    private val api = Retrofit.Builder()
        .baseUrl(GITHUB_BASE_URL)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .connectTimeout(timeoutInSeconds, TimeUnit.SECONDS)
                .readTimeout(timeoutInSeconds, TimeUnit.SECONDS)
                .writeTimeout(timeoutInSeconds, TimeUnit.SECONDS)
                .addInterceptor(githubHeaderInterceptor())
                .build()
        )
        .build()
        .create(GithubApi::class.java)

    private fun githubHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->

            val original = chain.request()
            val request = original.newBuilder()
                .header("Accept", "application/vnd.github.v3+json")
                .method(original.method(), original.body())
                .build()

            chain.proceed(request)
        }
    }

    override fun getUserRepos(userName: String): Deferred<ReposResponse> {
        return api.getUserRepos(userName)
    }
}