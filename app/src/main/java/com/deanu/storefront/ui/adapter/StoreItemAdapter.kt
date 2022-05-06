package com.deanu.storefront.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.deanu.storefront.data.models.StoreItemModel
import com.deanu.storefront.databinding.StoreItemBinding

class StoreItemAdapter :
    ListAdapter<StoreItemModel, StoreItemAdapter.ViewHolder>(StoreItemDiffCallback()) {

    // Diff util
    class StoreItemDiffCallback : DiffUtil.ItemCallback<StoreItemModel>() {
        override fun areItemsTheSame(oldItem: StoreItemModel, newItem: StoreItemModel): Boolean {
            return (oldItem.id == newItem.id)
        }

        override fun areContentsTheSame(oldItem: StoreItemModel, newItem: StoreItemModel): Boolean {
            return (oldItem == newItem)
        }
    }

    class ViewHolder(private val binding: StoreItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun inflateFrom(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = StoreItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(storeItemModel: StoreItemModel) {
            binding.storeItem = storeItemModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.inflateFrom(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}