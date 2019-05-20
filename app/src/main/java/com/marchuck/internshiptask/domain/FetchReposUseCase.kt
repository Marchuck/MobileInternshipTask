package com.marchuck.internshiptask.domain

import com.marchuck.internshiptask.data.GithubApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FetchReposUseCase(val apiClient: GithubApi) {

    suspend fun execute(userName: String): ReposState {
        return withContext(Dispatchers.IO) {
            try {
                val it = apiClient.getUserRepos(userName).await()
                if (it.isNotEmpty()) {
                    ReposState.Repos(it)
                } else {
                    ReposState.EmptyRepos
                }
            } catch (x: Exception) {
                x.printStackTrace()
                System.err.println("error fetching ${x.localizedMessage}")
                ReposState.Error(x.localizedMessage)
            }
        }
    }

}