package com.example.quotesfullmvvm.model

sealed class BaseResponse<T>(val data: T?, val errorMessage: String?) {

    class LOADING<T> : BaseResponse<T>(data = null, errorMessage = null)
    class SUCCESS<T>(data: T?) : BaseResponse<T>(data = data, errorMessage = null)
    class ERROR<T>(errorMessage: String?) :
        BaseResponse<T>(data = null, errorMessage = errorMessage)

}