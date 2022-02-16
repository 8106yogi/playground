package com.example.quotesfullmvvm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quotesfullmvvm.repository.MainRepository
import com.example.quotesfullmvvm.viewmodel.MainViewModel

class MainViewModelFactory(val repository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}