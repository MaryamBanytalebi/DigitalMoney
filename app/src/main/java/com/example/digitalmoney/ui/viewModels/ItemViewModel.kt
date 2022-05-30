package com.example.digitalmoney.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digitalmoney.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun fetchItems(){

        viewModelScope.launch {

            try {
                val fetchItems =
                    repository.getItems()
            }catch (e: Exception) {
                Log.e("TAG", "fetchItems: ${e.message}")
            }
        }
    }
}