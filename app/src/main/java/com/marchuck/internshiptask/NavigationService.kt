package com.marchuck.internshiptask

import com.marchuck.internshiptask.data.model.Repo

interface NavigationService {
    fun goToRepoDetail(repo: Repo)
}