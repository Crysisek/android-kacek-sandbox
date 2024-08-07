package com.kacek.core.network.client

import com.kacek.core.kotlin.coroutines.api.providers.DispatcherProvider
import com.kacek.core.network.api.client.NetworkClient
import com.kacek.core.network.mapper.KtorHttpResponseToResponseMapper
import com.kacek.core.network.mapper.RequestToKtorHttpRequestBuilderMapper
import com.kacek.core.network.model.request.Request
import com.kacek.core.network.model.response.Response
import com.kacek.core.network.model.response.ResponseTypeInfo
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.request
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class NetworkClientImpl(
    private val dispatcherProvider: DispatcherProvider,
) : NetworkClient() {
    private val requestMapper = RequestToKtorHttpRequestBuilderMapper()
    private val responseMapper = KtorHttpResponseToResponseMapper()

    override suspend fun <T> executeRequest(
        request: Request<T>,
        responseType: ResponseTypeInfo,
    ): Result<Response<T>> {
        return withContext(dispatcherProvider.io) {
            try {
                val requestBuilder = requestMapper.map(request)
                val httpResponse = client.request(requestBuilder)

                Result.success(responseMapper.map(httpResponse, responseType))
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    private val client = HttpClient(OkHttp) {
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    println("KTOR CLIENT: $message") // TODO implement professional logger
                }
            }
            level = LogLevel.ALL
        }

        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }
            )
        }

        install(DefaultRequest) {
            host = DEFAULT_HOSTNAME
        }
    }

    private companion object {
        const val DEFAULT_HOSTNAME = "api.coincap.io/v2"
    }
}
