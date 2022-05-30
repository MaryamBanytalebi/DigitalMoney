package com.example.digitalmoney.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalmoney.R
import com.example.digitalmoney.databinding.FragmentListBinding
import com.example.digitalmoney.ui.adapter.ItemsAdapter
import com.example.digitalmoney.ui.viewModels.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var itemsAdapter: ItemsAdapter
    private lateinit var viewModel : ItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
        setUpAdapter()
        setUpRecycle()

    }

    private fun setUpViewModel(){
        viewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        viewModel.fetchItems()
    }

    private fun setUpRecycle(){

        binding.recyclerItems.apply {
            layoutManager = LinearLayoutManager(context)
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            adapter = itemsAdapter
        }
    }

    private fun setUpAdapter(){
        itemsAdapter = ItemsAdapter().also {
            it.onItemClick = {//TODO
                findNavController().navigate(R.id.detailFragment)
            }
        }
    }
}