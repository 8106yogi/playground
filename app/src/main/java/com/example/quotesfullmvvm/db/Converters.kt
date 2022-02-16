package com.example.quotesfullmvvm.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun convertObjectToString(value: List<String>?): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun convertStringToObject(value: String): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, type)
    }
}