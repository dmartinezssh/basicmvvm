package com.example.basicmvvm.data

import com.example.basicmvvm.data.database.dao.QuoteDAO
import com.example.basicmvvm.data.database.entities.QuoteEntity
import com.example.basicmvvm.data.model.QuoteModel
import com.example.basicmvvm.data.model.QuoteProvider
import com.example.basicmvvm.data.network.QuoteService
import com.example.basicmvvm.domain.model.Quote
import com.example.basicmvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api:QuoteService,
    private val quoteDAO: QuoteDAO
) {

    suspend fun getAllQuotesFromApi():List<Quote>{
        val response = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase():List<Quote> {
        val response = quoteDAO.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDAO.insertAll(quotes)
    }

    suspend fun deleteAllQuotes() {
        quoteDAO.deleteAllQuotes()
    }
}