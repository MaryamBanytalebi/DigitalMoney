package com.example.digitalmoney.data.repository

import com.example.digitalmoney.data.ApiService

class Repository constructor(private val apiService: ApiService){

    suspend fun getItems() = apiService.items()


}