package com.kacek.core.network.model.response

data class Response<T>(
    val statusCode: Int,
    val content: T,
)
