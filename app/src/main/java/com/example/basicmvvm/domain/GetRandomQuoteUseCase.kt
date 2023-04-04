package com.example.basicmvvm.domain

import com.example.basicmvvm.data.QuoteRepository
import com.example.basicmvvm.data.model.QuoteModel
import com.example.basicmvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider) {

    operator fun invoke():QuoteModel? {
        val quotes = quoteProvider.quotes
        if(!quotes.isNullOrEmpty()) {
            val randomNumer = (0..quotes.size-1).random()
            return quotes[randomNumer]
        }
        return null
    }
}