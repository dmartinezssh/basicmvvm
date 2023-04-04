package com.example.basicmvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.basicmvvm.data.database.dao.QuoteDAO
import com.example.basicmvvm.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {
    abstract fun getQuoteDAO():QuoteDAO
}