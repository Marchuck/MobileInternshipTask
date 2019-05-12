package com.marchuck.internshiptask

import android.app.Activity
import com.marchuck.internshiptask.data.model.Repo
import com.marchuck.internshiptask.view.repo_detail.RepoDetailActivity

class ActivityNavigationService(val activity: Activity?) : NavigationService {

    override fun goToRepoDetail(repo: Repo) {
        activity?.startActivity(RepoDetailActivity.createIntent(activity, repo))
    }

}