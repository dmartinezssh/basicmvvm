package com.example.basicmvvm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://one.alpura.com:17105/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}