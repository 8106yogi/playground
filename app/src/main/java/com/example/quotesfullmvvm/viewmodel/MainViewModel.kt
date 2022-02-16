package com.example.quotesfullmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesfullmvvm.model.BaseResponse
import com.example.quotesfullmvvm.model.QuotesResponse
import com.example.quotesfullmvvm.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository) : ViewModel() {
    val quotesResponse: LiveData<BaseResponse<QuotesResponse>>
        get() = repository.quotesResponse

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)
        }
    }
}