package com.example.digitalmoney.data

import com.example.digitalmoney.model.Data
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("digital-money")
    suspend fun getItems() : Response<Data>

}