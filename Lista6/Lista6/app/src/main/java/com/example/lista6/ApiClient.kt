package com.example.lista6

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://random-data-api.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}