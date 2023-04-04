package com.example.basicmvvm.domain.model

import com.example.basicmvvm.data.database.entities.QuoteEntity
import com.example.basicmvvm.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)

fun QuoteEntity.toDomain() = Quote(quote, author)