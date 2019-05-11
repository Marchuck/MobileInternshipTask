package com.marchuck.azimointernshiptask.view.repos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.marchuck.azimointernshiptask.BR
import com.marchuck.azimointernshiptask.R
import com.marchuck.azimointernshiptask.data.model.Repo
import com.marchuck.azimointernshiptask.data.model.ReposResponse


typealias ItemBinding = com.marchuck.azimointernshiptask.databinding.RepoItemBinding

class ReposAdapter : RecyclerView.Adapter<RepoViewHolder>() {

    var clickListener: ((item: Repo) -> Unit)? = null
    var items = ReposResponse()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.repo_item, parent, false)
        return RepoViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = items[position]
        holder.bind(repo)
        holder.itemView.setOnClickListener {
            clickListener?.invoke(repo)
        }
    }
}

class RepoViewHolder(val itemBinding: ItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(repo: Repo) {
        itemBinding.setVariable(BR.item, repo)
//        itemBinding.setVariable(BR.clickHandler,)
        itemBinding.executePendingBindings()
    }
}