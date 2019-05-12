package com.marchuck.internshiptask.view.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marchuck.internshiptask.NavigationService
import com.marchuck.internshiptask.data.model.Repo
import com.marchuck.internshiptask.data.model.ReposResponse
import com.marchuck.internshiptask.domain.FetchReposUseCase
import com.marchuck.internshiptask.domain.ReposState
import kotlinx.coroutines.launch

class SearchUserViewModel(
    val fetchReposUseCase: FetchReposUseCase,
    val navigationService: NavigationService
) : ViewModel() {

    val userName = MutableLiveData<String>().apply { value = "" }
    val loadingPresented = MutableLiveData<Boolean>().apply { value = false }
    val errorMessage = MutableLiveData<String>().apply { value = "" }
    val repos = MutableLiveData<ReposResponse>().apply { value = ReposResponse() }
    val reposAreEmpty = MutableLiveData<Boolean>().apply { value = false }

    fun requestUserRepos() {
        loadingPresented.postValue(true)
        errorMessage.postValue("")

        val name = userName.value?.trim() ?: ""

        if (name.isNotEmpty()) {

            viewModelScope.launch {
                val state = fetchReposUseCase.execute(name)

                loadingPresented.postValue(true)

                when (state) {
                    is ReposState.Error -> {
                        loadingPresented.postValue(false)
                        errorMessage.postValue(state.readableMessage)
                    }
                    is ReposState.EmptyRepos -> {
                        loadingPresented.postValue(false)
                        reposAreEmpty.postValue(true)
                    }
                    is ReposState.Repos -> {
                        loadingPresented.postValue(false)
                        repos.postValue(state.repos)
                    }
                }
            }
        } else {
            errorMessage.value = "Please enter github username"
        }
    }

    fun navigateToRepository(repo: Repo) {
        navigationService.goToRepoDetail(repo )
    }
}
