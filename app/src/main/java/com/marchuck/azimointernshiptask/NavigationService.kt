package com.marchuck.azimointernshiptask

import com.marchuck.azimointernshiptask.data.model.Repo

interface NavigationService {
    fun goToRepoDetail(repo: Repo)
}