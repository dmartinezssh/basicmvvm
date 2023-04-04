package com.example.basicmvvm.domain

import com.example.basicmvvm.data.QuoteRepository
import com.example.basicmvvm.data.database.entities.toDatabase
import com.example.basicmvvm.data.model.QuoteModel
import com.example.basicmvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {

    suspend operator fun invoke(): List<Quote>? {
        val quotes = repository.getAllQuotesFromApi()
        return if(quotes.isNotEmpty()) {
            repository.deleteAllQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }
    }

}