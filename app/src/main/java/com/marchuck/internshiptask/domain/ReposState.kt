package com.marchuck.internshiptask.domain

import com.marchuck.internshiptask.data.model.ReposResponse

sealed class ReposState {

    data class Repos(val repos: ReposResponse) : ReposState()

    object EmptyRepos : ReposState()

    data class Error(val readableMessage: String) : ReposState()

}