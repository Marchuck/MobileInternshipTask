package com.marchuck.internshiptask.view.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.marchuck.internshiptask.ActivityNavigationService
import com.marchuck.internshiptask.R
import com.marchuck.internshiptask.data.GithubClient
import com.marchuck.internshiptask.domain.FetchReposUseCase
import com.marchuck.internshiptask.view.repos.ReposAdapter

class SearchUserFragment : Fragment() {

    companion object {
        fun newInstance() = SearchUserFragment()
    }

    var binding: com.marchuck.internshiptask.databinding.SearchUserFragmentBinding? = null

    private lateinit var viewModel: SearchUserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.search_user_fragment, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = SearchUserViewModel(FetchReposUseCase(GithubClient()), ActivityNavigationService(activity))

        binding?.lifecycleOwner = this

        val adapter = ReposAdapter()

        adapter.clickListener = {
            viewModel.navigateToRepository(it)
        }
        binding?.adapter = adapter
        binding?.viewModel = viewModel
    }
}
