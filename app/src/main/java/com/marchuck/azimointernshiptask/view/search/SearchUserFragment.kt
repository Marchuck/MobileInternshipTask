package com.marchuck.azimointernshiptask.view.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.marchuck.azimointernshiptask.R
import com.marchuck.azimointernshiptask.data.GithubClient
import com.marchuck.azimointernshiptask.domain.FetchReposUseCase

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
        viewModel = SearchUserViewModel(FetchReposUseCase(GithubClient()))

        binding?.lifecycleOwner = this
        binding?.viewModel = viewModel
    }
}
