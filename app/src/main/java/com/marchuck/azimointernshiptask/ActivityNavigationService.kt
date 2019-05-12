package com.marchuck.azimointernshiptask

import android.app.Activity
import com.marchuck.azimointernshiptask.data.model.Repo
import com.marchuck.azimointernshiptask.view.repo_detail.RepoDetailActivity

class ActivityNavigationService(val activity: Activity?) : NavigationService {

    override fun goToRepoDetail(repo: Repo) {
        activity?.startActivity(RepoDetailActivity.createIntent(activity, repo))
    }

}