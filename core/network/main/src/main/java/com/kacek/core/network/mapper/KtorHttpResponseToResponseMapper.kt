package com.kacek.core.network.mapper

import com.kacek.core.network.model.response.Response
import com.kacek.core.network.model.response.ResponseTypeInfo
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.util.reflect.TypeInfo

internal class KtorHttpResponseToResponseMapper {

    suspend fun <T> map(
        httpResponse: HttpResponse,
        responseType: ResponseTypeInfo,
    ): Response<T> {
        return Response(
            statusCode = httpResponse.status.value,
            content = httpResponse.body(responseType.toKtorTypeInfo()),
        )
    }

    private fun ResponseTypeInfo.toKtorTypeInfo() = TypeInfo(type, reifiedType, kotlinType)
}
