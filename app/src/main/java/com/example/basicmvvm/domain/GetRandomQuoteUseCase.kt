package com.example.basicmvvm.domain

import com.example.basicmvvm.data.QuoteRepository
import com.example.basicmvvm.data.model.QuoteModel
import com.example.basicmvvm.data.model.QuoteProvider
import com.example.basicmvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke():Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if(!quotes.isNullOrEmpty()) {
            val randomNumer = (0..quotes.size-1).random()
            return quotes[randomNumer]
        }
        return null
    }
}