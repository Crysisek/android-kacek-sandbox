package com.kacek.core.network.mapper

import com.kacek.core.network.model.request.Request
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.HttpMethod

class RequestToKtorHttpRequestBuilderMapper {

    fun <T> map(param: Request<T>): HttpRequestBuilder {
        return HttpRequestBuilder().apply {
            method = param.method.toKtorHttpMethod()
            url(param.formatPath())
            param.queryParameters?.forEach { param ->
                parameter(param.key, param.value)
            }
            param.headers?.forEach { (key, value) ->
                header(key, value)
            }
            param.body?.let { requestBody ->
                setBody(requestBody)
            }
        }
    }

    private fun Request.HttpMethod.toKtorHttpMethod(): HttpMethod {
        return when (this) {
            Request.HttpMethod.GET -> HttpMethod.Get
            Request.HttpMethod.POST -> HttpMethod.Post
            Request.HttpMethod.PUT -> HttpMethod.Put
            Request.HttpMethod.PATCH -> HttpMethod.Patch
            Request.HttpMethod.DELETE -> HttpMethod.Delete
            Request.HttpMethod.HEAD -> HttpMethod.Head
            Request.HttpMethod.OPTIONS -> HttpMethod.Options
        }
    }

    private fun <T> Request<T>.formatPath() = when {
        path.contains("://") || path.startsWith("/") -> path
        else -> "/${path}"
    }
}
