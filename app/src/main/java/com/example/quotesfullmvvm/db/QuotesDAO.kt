package com.example.quotesfullmvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.quotesfullmvvm.model.Result

@Dao
interface QuotesDAO {
    @Insert(onConflict = REPLACE)
    suspend fun insertQuotes(quotes: List<Result>)

    @Query("select * from quotes")
    fun getQuotes(): List<Result>
}