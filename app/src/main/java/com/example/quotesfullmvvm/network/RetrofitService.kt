package com.example.quotesfullmvvm.network

import com.example.quotesfullmvvm.model.QuotesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("quotes")
    suspend fun getQuotes(@Query("page") page: Int): Response<QuotesResponse>

}