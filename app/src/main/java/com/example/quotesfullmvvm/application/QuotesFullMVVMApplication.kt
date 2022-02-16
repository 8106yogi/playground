package com.example.quotesfullmvvm.application

import android.app.Application
import com.example.quotesfullmvvm.db.QuoteDB
import com.example.quotesfullmvvm.network.RetrofitHelper
import com.example.quotesfullmvvm.network.RetrofitService
import com.example.quotesfullmvvm.repository.MainRepository

class QuotesFullMVVMApplication : Application() {

    lateinit var repository: MainRepository
    override fun onCreate() {
        super.onCreate()
        val retrofitService =
            RetrofitHelper.getInstance().create(RetrofitService::class.java)

        val quotesDAO = QuoteDB.getDatabase(applicationContext).getQuotesDao()

        repository = MainRepository(retrofitService, quotesDAO,applicationContext);

    }
}