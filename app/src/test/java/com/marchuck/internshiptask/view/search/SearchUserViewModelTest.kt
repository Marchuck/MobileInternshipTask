package com.marchuck.internshiptask.view.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jraska.livedata.test
import com.marchuck.internshiptask.NavigationService
import com.marchuck.internshiptask.data.model.Repo
import com.marchuck.internshiptask.domain.FetchReposUseCase
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class SearchUserViewModelTest {
    @get:Rule
    val testRule = InstantTaskExecutorRule()

    @Test
    fun x(){
        val useCase = Mockito.mock(FetchReposUseCase::class.java)
        val navService = Mockito.mock(NavigationService::class.java)

        val userName="Marchuck"

        val repo = Mockito.mock(Repo::class.java)

        //todo: test suspended calls
        //useCase.execute(userName)

        val viewModel = SearchUserViewModel(useCase, navService)

        viewModel.userName.value = userName

        viewModel.requestUserRepos()

        viewModel.loadingPresented.test().assertValue(true)

    }

    @Test
    fun navigatesOk() {
        val useCase = Mockito.mock(FetchReposUseCase::class.java)
        val navService = Mockito.mock(NavigationService::class.java)

        val repo = Mockito.mock(Repo::class.java)

        val viewModel = SearchUserViewModel(useCase, navService)

        viewModel.navigateToRepository(repo)

        Mockito.verify(navService).goToRepoDetail(repo)
    }

}
