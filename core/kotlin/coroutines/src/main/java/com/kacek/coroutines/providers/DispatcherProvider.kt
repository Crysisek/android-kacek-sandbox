package com.kacek.coroutines.providers

import kotlin.coroutines.CoroutineContext

interface DispatcherProvider {
    val default: CoroutineContext
    val main: CoroutineContext
    val io: CoroutineContext
    val unconfined: CoroutineContext
}
