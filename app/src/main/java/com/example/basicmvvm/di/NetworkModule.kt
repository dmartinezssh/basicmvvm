package com.example.basicmvvm.di

import com.example.basicmvvm.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://one.alpura.com:17105/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApliClient(retrofit: Retrofit):QuoteApiClient {
        return retrofit.create(QuoteApiClient::class.java)
    }
}