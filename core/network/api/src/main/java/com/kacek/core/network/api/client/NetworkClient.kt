package com.kacek.core.network.api.client

import com.kacek.core.network.model.request.Request
import com.kacek.core.network.model.response.Response
import com.kacek.core.network.model.response.ResponseTypeInfo
import kotlin.reflect.javaType
import kotlin.reflect.typeOf

abstract class NetworkClient {
    protected abstract suspend fun <T> executeRequest(
        request: Request<T>,
        responseType: ResponseTypeInfo,
    ): Result<Response<T>>

    @PublishedApi
    internal suspend fun <T> internalRequest(
        request: Request<T>,
        responseType: ResponseTypeInfo,
    ): Result<Response<T>> = executeRequest(request, responseType)
}

/**
 * Executes [request] and produces a [Result] of [Response].
 * Map's its [Response] to the type defined in [Request] generic.
 *
 * This is the main entry-point of the [NetworkClient] for its consumers.
 */
@OptIn(ExperimentalStdlibApi::class)
suspend inline fun <reified T> NetworkClient.request(
    request: Request<T>,
): Result<Response<T>> {
    val responseType = typeOf<T>()

    return internalRequest(
        request = request,
        responseType = ResponseTypeInfo(
            type = T::class,
            reifiedType = responseType.javaType,
            kotlinType = responseType
        )
    )
}
