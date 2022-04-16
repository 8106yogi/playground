package com.example.quotesfullmvvm.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.quotesfullmvvm.MainActivity
import com.example.quotesfullmvvm.MainActivityDiffUtilList
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, QuoteDbModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(mainActivityDiffUtilList: MainActivityDiffUtilList)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent

    }
}