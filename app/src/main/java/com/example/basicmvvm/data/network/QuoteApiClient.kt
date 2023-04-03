package com.example.basicmvvm.data.network

import com.example.basicmvvm.data.model.QuoteModel
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("quotes")
    suspend fun getAllQuotes():retrofit2.Response<List<QuoteModel>>
}