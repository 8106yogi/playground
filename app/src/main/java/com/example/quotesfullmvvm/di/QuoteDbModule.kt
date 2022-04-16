package com.example.quotesfullmvvm.di

import android.content.Context
import androidx.room.Room
import com.example.quotesfullmvvm.db.QuoteDB
import com.example.quotesfullmvvm.db.QuotesDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class QuoteDbModule {

    @Singleton
    @Provides
    fun providesQuoteDB(context: Context): QuoteDB {
        return Room.databaseBuilder(context, QuoteDB::class.java, "QuoteDB").build()
    }

    @Singleton
    @Provides
    fun providesQuoteDao(quoteDB: QuoteDB): QuotesDAO {
        return quoteDB.getQuotesDao()

    }
}