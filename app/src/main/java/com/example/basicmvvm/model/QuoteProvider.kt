package com.example.basicmvvm.model

class QuoteProvider {
    companion object {

        fun random():QuoteModel {
            val position = (0..5).random()
            return quote[position]
        }

        val quote = listOf<QuoteModel>(
            QuoteModel(
                quote= "Frase de inspiración 1",
                author= "my author 1"
            ),
            QuoteModel(
                quote= "Frase de inspiración 2",
                author= "my author 2"
            ),
            QuoteModel(
                quote= "Frase de inspiración 3",
                author= "my author 3"
            ),
            QuoteModel(
                quote= "Frase de inspiración 4",
                author= "my author 4"
            ),
            QuoteModel(
                quote= "Frase de inspiración 5",
                author= "my author 5"
            )
        )
    }
}