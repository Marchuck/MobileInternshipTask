package com.marchuck.azimointernshiptask.view.repo_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.marchuck.azimointernshiptask.R
import com.marchuck.azimointernshiptask.data.model.Repo
import com.marchuck.azimointernshiptask.databinding.ActivityRepoDetailBinding

const val REPO = "REPO"

class RepoDetailActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context, repo: Repo?): Intent {
            return Intent(context, RepoDetailActivity::class.java)
                .apply { putExtra(REPO, repo) }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repo = intent?.getSerializableExtra(REPO) as? Repo

        val binding: ActivityRepoDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_repo_detail)

        binding.lifecycleOwner = this
        if (repo != null) {
            binding.repo = repo
        }
    }
}
