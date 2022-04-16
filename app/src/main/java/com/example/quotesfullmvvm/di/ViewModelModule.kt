package com.example.quotesfullmvvm.di

import androidx.lifecycle.ViewModel
import com.example.quotesfullmvvm.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
//    @StringKey("mainViewModel")
    @ClassKey(MainViewModel::class)
    @IntoMap
    abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel
}