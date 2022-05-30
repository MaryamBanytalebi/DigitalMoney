package com.example.digitalmoney.di

import com.example.digitalmoney.data.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun retrofit() : Retrofit = Retrofit.Builder()
        .baseUrl("https://www.megaweb.ir/api/")
        .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun apiService(retrofit: Retrofit) : ApiService = retrofit.create(ApiService :: class.java)
}