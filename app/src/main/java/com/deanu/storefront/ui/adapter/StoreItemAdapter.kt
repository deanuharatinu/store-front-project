package com.deanu.storefront.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.deanu.storefront.data.models.StoreItemModel
import com.deanu.storefront.databinding.StoreItemBinding
import com.deanu.storefront.utils.smartTruncate


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
            binding.shortTitle = storeItemModel.title.smartTruncate(15)
            Glide.with(binding.root)
                .load(storeItemModel.imageUrl)
                .apply(RequestOptions().override(600, 600))
                .into(binding.ivGlide)
//            binding.shimmerViewContainer.stopShimmer()
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