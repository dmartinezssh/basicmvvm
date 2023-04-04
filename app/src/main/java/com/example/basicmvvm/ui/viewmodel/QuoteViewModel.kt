package com.example.basicmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicmvvm.data.model.QuoteModel
import com.example.basicmvvm.data.model.QuoteProvider
import com.example.basicmvvm.domain.GetQuotesUseCase
import com.example.basicmvvm.domain.GetRandomQuoteUseCase
import com.example.basicmvvm.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuoteUseCase:GetQuotesUseCase,
    private val getRandomQuoteUseCase:GetRandomQuoteUseCase
) : ViewModel() {
    val quoteModel = MutableLiveData<Quote>();
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuoteUseCase()
            if(!result.isNullOrEmpty()) {
                quoteModel.postValue(result[1])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val quote = getRandomQuoteUseCase()
            if(quote != null) {
                quoteModel.postValue(quote)
            }
            isLoading.postValue(false)
        }

    }


}