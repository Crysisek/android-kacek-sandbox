package com.kacek.core.kotlin.coroutines.di

import com.kacek.core.kotlin.coroutines.api.providers.DispatcherProvider
import com.kacek.core.kotlin.coroutines.providers.CoroutineDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoroutinesModule {

    @Provides
    @Singleton
    fun provideDispatcherProvider(): DispatcherProvider {
        return CoroutineDispatcherProvider()
    }
}
