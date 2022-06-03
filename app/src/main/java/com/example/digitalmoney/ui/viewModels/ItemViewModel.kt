package com.example.digitalmoney.ui.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digitalmoney.data.repository.Repository
import com.example.digitalmoney.data.model.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _itemList = MutableLiveData<List<Data>>()
    val itemList get() = _itemList

    fun fetchItems(){

        viewModelScope.launch {

            try {
                val response =
                    repository.getItems()
                with(response) {
                    if (isSuccessful) {
                        body()?.let {
                            _itemList.postValue(it.data)
                        }

                    } else {
                        Log.d("TAG", "fetchItems1: ${message()}")
                    }
                }
            }catch (e: Exception) {
                Log.d("TAG", "fetchItems2: ${e.message}")
            }
        }

    }

    fun sort(text:String){
        when(text){
            "Price in USD" -> {_itemList.postValue(_itemList.value?.sortedWith(compareBy { data-> data.priceUsd}))}
            "Rank" -> {_itemList.postValue(_itemList.value?.sortedBy { data-> data.rank})}
            "Name" -> {_itemList.postValue(_itemList.value?.sortedBy { data-> data.name})}
        }
    }
}