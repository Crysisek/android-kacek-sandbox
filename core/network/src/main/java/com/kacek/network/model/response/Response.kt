package com.kacek.network.model.response

data class Response<T>(
    val statusCode: Int,
    val content: T,
)
