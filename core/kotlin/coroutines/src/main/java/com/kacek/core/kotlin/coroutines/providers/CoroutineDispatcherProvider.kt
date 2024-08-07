package com.kacek.core.kotlin.coroutines.providers

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

internal class CoroutineDispatcherProvider : DispatcherProvider {
    override val default: CoroutineContext get() = Dispatchers.Default
    override val main: CoroutineContext get() = Dispatchers.Main
    override val io: CoroutineContext get() = Dispatchers.IO
    override val unconfined: CoroutineContext get() = Dispatchers.Unconfined
}
