package com.google.developer.bugmaster.presentation

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.developer.bugmaster.R

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return LoadingViewHolder(parent)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent) {
        private val layoutInflater = LayoutInflater.from(parent.context)

        init {
            layoutInflater.inflate(R.layout.insect_item_loading, parent, false)
        }
    }
}
