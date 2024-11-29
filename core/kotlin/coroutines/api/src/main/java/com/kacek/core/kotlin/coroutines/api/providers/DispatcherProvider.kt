package com.kacek.core.kotlin.coroutines.api.providers

import kotlin.coroutines.CoroutineContext

interface DispatcherProvider {
    val default: CoroutineContext
    val main: CoroutineContext
    val io: CoroutineContext
    val unconfined: CoroutineContext
}
