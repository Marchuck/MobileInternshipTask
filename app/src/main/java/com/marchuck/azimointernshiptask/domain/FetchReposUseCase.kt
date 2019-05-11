package com.marchuck.azimointernshiptask.domain

import com.marchuck.azimointernshiptask.data.GithubApi
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
                //todo: determine if user is empty
                x.printStackTrace()
                System.err.println("error fetching ${x.localizedMessage}")
                ReposState.Error(x.localizedMessage)
            }
        }
    }

}