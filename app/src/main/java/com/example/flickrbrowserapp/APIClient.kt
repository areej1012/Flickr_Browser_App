package com.example.flickrbrowserapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
     var retrofit: Retrofit? = null
    val keyAPI = "1ae6d33017f66d5276fddbba63a5acd2"

    fun getImage() : Retrofit?{
        retrofit = Retrofit.Builder()
            .baseUrl("https://www.flickr.com/services/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}