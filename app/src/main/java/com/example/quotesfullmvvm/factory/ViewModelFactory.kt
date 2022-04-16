package com.example.quotesfullmvvm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quotesfullmvvm.repository.MainRepository
import com.example.quotesfullmvvm.viewmodel.MainViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val map: Map<Class<*>,@JvmSuppressWildcards ViewModel>) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return map[modelClass] as T
    }
}