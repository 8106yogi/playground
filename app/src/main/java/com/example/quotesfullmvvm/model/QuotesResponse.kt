package com.example.quotesfullmvvm.model

data class QuotesResponse(
    val count: Int = 0,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)