package com.example.digitalmoney.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalmoney.databinding.ItemBinding
import com.example.digitalmoney.data.model.Data

class ItemsAdapter : ListAdapter<Data, ItemsAdapter.ViewHolder>(DiffUtilCallback()) {

    var onItemClick: ((Data) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick)
    }

    class ViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Data, onItemClick: ((Data) -> Unit)?) {
            with(binding){
                txtItemName.text = item.name
                txtItemUsd.text = item.priceUsd
//                itemImage.setImageResource()

                root.setOnClickListener {
                    onItemClick?.invoke(item)
                }
            }
        }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<Data>() {

        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }

    }

}