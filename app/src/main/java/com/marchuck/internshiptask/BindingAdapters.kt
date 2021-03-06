package com.marchuck.internshiptask

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marchuck.internshiptask.data.model.ReposResponse
import com.marchuck.internshiptask.view.repos.ReposAdapter

@BindingAdapter("adapter")
fun setAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {

    if (recyclerView.adapter == null) {
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = adapter
    }
}

@BindingAdapter("repoItems")
fun setReposItems(recyclerView: RecyclerView, repos: ReposResponse?) {
    if (recyclerView.adapter != null && repos?.isNotEmpty() == true) {
        (recyclerView.adapter as? ReposAdapter)?.let {
            it.items = repos
        }
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("starsCount")
fun starsCount(textView: TextView, stars: Int) {
    textView.text = "Stars: $stars"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("forksCount")
fun forksCount(textView: TextView, forks: Int) {
    textView.text = "Forks: $forks"
}
