package com.example.digitalmoney.data

import com.example.digitalmoney.data.model.Result
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("digital-money")
    suspend fun items() : Response<Result>

}