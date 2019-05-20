package com.marchuck.internshiptask.view.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jraska.livedata.test
import com.marchuck.internshiptask.NavigationService
import com.marchuck.internshiptask.data.model.Repo
import com.marchuck.internshiptask.domain.FetchReposUseCase
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class SearchUserViewModelTest {

    @get:Rule
    val testRule = InstantTaskExecutorRule()

    @ObsoleteCoroutinesApi
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @Test
    fun loadingPresented() {
        val useCase = Mockito.mock(FetchReposUseCase::class.java)
        val navService = Mockito.mock(NavigationService::class.java)

        val userName = "Marchuck"

        val viewModel = SearchUserViewModel(useCase, navService)

        viewModel.userName.value = userName

        runBlocking {

            viewModel.requestUserRepos()
        }

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

    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

}
