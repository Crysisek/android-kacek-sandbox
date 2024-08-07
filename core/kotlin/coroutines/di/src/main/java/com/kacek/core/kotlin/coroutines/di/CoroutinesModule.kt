package com.kacek.core.kotlin.coroutines.di

import com.kacek.core.kotlin.coroutines.api.providers.DispatcherProvider
import com.kacek.core.kotlin.coroutines.providers.CoroutineDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CoroutinesModule {

    @Provides
    fun provideDispatcherProvider(): DispatcherProvider {
        return CoroutineDispatcherProvider()
    }
}
