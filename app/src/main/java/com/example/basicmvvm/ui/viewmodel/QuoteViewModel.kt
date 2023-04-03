package com.example.basicmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicmvvm.data.model.QuoteModel
import com.example.basicmvvm.data.model.QuoteProvider
import com.example.basicmvvm.domain.GetQuotesUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>();
    var getQuoteUseCase = GetQuotesUseCase()
    fun onCreate() {
        viewModelScope.launch {
            val result = getQuoteUseCase()
            if(!result.isNullOrEmpty()) {
                quoteModel.postValue(result[1])
            }
        }
    }

    fun randomQuote() {
        /*val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)*/
    }


}