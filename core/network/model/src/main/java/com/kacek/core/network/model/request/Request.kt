package com.kacek.core.network.model.request

/**
 * [NetworkClient][com.kacek.network.client.NetworkClient]'s request configuration class.
 * [T] is the generic [Response][com.kacek.network.model.response.Response] type.
 * @property method: http method of a request
 * @property path: request path, either relative or absolute URL
 * @property queryParameters: query parameters appended to the URL
 * @property headers: headers appended after the [NetworkClient][com.kacek.network.client.NetworkClient]'s default headers
 * @property body: request's body, [kotlinx.serialization] models will be serialized automatically.
 */
data class Request<T>(
    val method: HttpMethod,
    val path: String,
    val queryParameters: Map<String, String>? = null,
    val headers: Map<String, String>? = null,
    @JvmField
    var body: Any? = null,
) {

    enum class HttpMethod {
        GET,
        POST,
        PUT,
        PATCH,
        DELETE,
        HEAD,
        OPTIONS,
    }
}
