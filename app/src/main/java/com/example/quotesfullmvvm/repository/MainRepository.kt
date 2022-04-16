package com.example.quotesfullmvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quotesfullmvvm.db.QuotesDAO
import com.example.quotesfullmvvm.model.BaseResponse
import com.example.quotesfullmvvm.model.BaseResponse.*
import com.example.quotesfullmvvm.model.QuotesResponse
import com.example.quotesfullmvvm.network.RetrofitService
import com.example.quotesfullmvvm.utils.NetworkUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val retrofitService: RetrofitService,
    private val quotesDAO: QuotesDAO,
  @ApplicationContext  private val context: Context
) {

    private val _quotesResponse: MutableLiveData<BaseResponse<QuotesResponse>> =
        MutableLiveData()

    val quotesResponse: LiveData<BaseResponse<QuotesResponse>>
        get() = _quotesResponse

    suspend fun getQuotes(page: Int) {
        try {
            _quotesResponse.postValue(LOADING())

            if (NetworkUtils.isNetworkConnected(context)) {
                val result = retrofitService.getQuotes(page)
                if (result.isSuccessful && result.body() != null) {
                    _quotesResponse.postValue(SUCCESS(result.body()))
                    quotesDAO.insertQuotes(result.body()!!.results)
                } else {
                    _quotesResponse.postValue(ERROR(result.errorBody()?.toString()))
                }

            } else {
                val quotes = quotesDAO.getQuotes()
                val quotesResponse = QuotesResponse(
                    1, 1, 1,
                    quotes, 1, 1
                )
                _quotesResponse.postValue(SUCCESS(quotesResponse))
            }
        } catch (e: Exception) {
            _quotesResponse.postValue(ERROR(e.localizedMessage))
        }
    }
}