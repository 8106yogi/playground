package com.example.quotesfullmvvm.application

import android.app.Application
import com.example.quotesfullmvvm.di.ApplicationComponent
import com.example.quotesfullmvvm.di.DaggerApplicationComponent

class QuotesFullMVVMApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)

    }
}