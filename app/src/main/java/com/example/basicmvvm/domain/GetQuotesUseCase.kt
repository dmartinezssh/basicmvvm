package com.example.basicmvvm.domain

import com.example.basicmvvm.data.QuoteRepository
import com.example.basicmvvm.data.model.QuoteModel

class GetQuotesUseCase {
    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()

}