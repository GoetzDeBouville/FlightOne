package com.starbars.search.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.starbars.search.domain.model.BaseIdentifiable

class DiffCallback<T : BaseIdentifiable> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}
