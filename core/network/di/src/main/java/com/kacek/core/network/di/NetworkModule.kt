package com.kacek.core.network.di

import com.kacek.core.kotlin.coroutines.api.providers.DispatcherProvider
import com.kacek.core.network.api.client.NetworkClient
import com.kacek.core.network.client.NetworkClientImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkClient(
        dispatcherProvider: DispatcherProvider,
    ): NetworkClient {
        return NetworkClientImpl(dispatcherProvider)
    }
}
