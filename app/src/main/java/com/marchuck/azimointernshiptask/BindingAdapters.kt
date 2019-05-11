package com.marchuck.azimointernshiptask

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marchuck.azimointernshiptask.data.model.ReposResponse
import com.marchuck.azimointernshiptask.view.repos.ReposAdapter

@BindingAdapter("repos")
fun setItems(recyclerView: RecyclerView, repos: ReposResponse) {
    if (repos.isEmpty()) return

    if (recyclerView.adapter == null) {
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = ReposAdapter().apply { items = repos }
    } else if (recyclerView.adapter is ReposAdapter) {
        (recyclerView.adapter as? ReposAdapter)?.let { reposAdapter ->
            reposAdapter.apply { items = repos }
        }
    }
}
