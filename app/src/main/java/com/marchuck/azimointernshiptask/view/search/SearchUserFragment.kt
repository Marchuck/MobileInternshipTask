package com.marchuck.azimointernshiptask.view.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.marchuck.azimointernshiptask.ActivityNavigationService
import com.marchuck.azimointernshiptask.R
import com.marchuck.azimointernshiptask.data.GithubClient
import com.marchuck.azimointernshiptask.domain.FetchReposUseCase
import com.marchuck.azimointernshiptask.view.repos.ReposAdapter

class SearchUserFragment : Fragment() {

    companion object {
        fun newInstance() = SearchUserFragment()
    }

    var binding: com.marchuck.azimointernshiptask.databinding.SearchUserFragmentBinding? = null

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
