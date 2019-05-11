package com.marchuck.azimointernshiptask.domain

import com.marchuck.azimointernshiptask.data.model.ReposResponse

sealed class ReposState {

    object Loading : ReposState()

    data class Repos(val repos: ReposResponse) : ReposState()

    object EmptyRepos : ReposState()

    data class Error(val readableMessage: String) : ReposState()

    object UserNotFound : ReposState()

}