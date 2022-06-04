package com.example.digitalmoney.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalmoney.databinding.ItemBinding
import com.example.digitalmoney.data.model.Data
import com.example.digitalmoney.data.repository.Repository
import com.squareup.picasso.Picasso

class ItemsAdapter : ListAdapter<Data, ItemsAdapter.ViewHolder>(DiffUtilCallback()) {

    var onItemClick: ((Data) -> Unit)? = null
    val images = mapOf(
        "Bitcoin" to "https://www.freepik.com/free-vector/golden-coin-with-word-bitcoin_2094980.htm#query=coin&position=22&from_view=search",
        "Ethereum" to "https://www.freepik.com/free-vector/golden-coin-with-word-bitcoin_2094980.htm#query=coin&position=22&from_view=search",
        "Cardano" to "https://www.freepik.com/free-vector/golden-coin-with-word-bitcoin_2094980.htm#query=coin&position=22&from_view=search"
    )


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

    inner class ViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Data, onItemClick: ((Data) -> Unit)?) {

            with(binding) {
                txtItemName.text = item.name
                txtItemUsd.text = item.priceUsd
                when (item.name) {
                    "Bitcoin" -> {
                        Picasso.get().load(images[item.name]).into(itemImage)
                    }
                    "Ethereum" -> {
                        Picasso.get().load(images[item.name]).into(itemImage)
                    }
                    "Cardano" -> {
                        Picasso.get().load(images[item.name]).into(itemImage)
                        Log.d("TAG", "bind: "+ Picasso.get().load(images[item.name]).into(itemImage))
                    }
                }
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