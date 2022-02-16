package com.example.quotesfullmvvm.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.quotesfullmvvm.model.Result

@Database(entities = [Result::class], version = 1)
@TypeConverters(Converters::class)
abstract class QuoteDB : RoomDatabase() {

    abstract fun getQuotesDao(): QuotesDAO


    companion object {
        @Volatile
        private var INSTANCE: QuoteDB? = null

        fun getDatabase(context: Context): QuoteDB {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, QuoteDB::class.java, "quotesDB").build()

                }
            }
            return INSTANCE!!
        }
    }

}