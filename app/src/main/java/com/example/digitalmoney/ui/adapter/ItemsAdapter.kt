package com.example.digitalmoney.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalmoney.databinding.ItemBinding
import com.example.digitalmoney.model.Item

class ItemsAdapter : ListAdapter<Item, ItemsAdapter.ViewHolder>(DiffUtilCallback()) {

    var onItemClick: ((Item) -> Unit)? = null

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

        fun bind(item: Item, onItemClick: ((Item) -> Unit)?) {
            with(binding){
                txtItemName.text = item.name
//                itemImage.setImageResource()

                root.setOnClickListener {
                    onItemClick?.invoke(item)
                }
            }
        }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<Item>() {

        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }

}