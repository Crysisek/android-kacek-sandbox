package com.kacek.core.network.di

import com.kacek.core.kotlin.coroutines.api.providers.DispatcherProvider
import com.kacek.core.network.api.client.NetworkClient
import com.kacek.core.network.client.NetworkClientImpl
import com.kacek.core.network.mapper.KtorHttpResponseToResponseMapper
import com.kacek.core.network.mapper.RequestToKtorHttpRequestBuilderMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRequestToKtorHttpRequestBuilderMapper(): RequestToKtorHttpRequestBuilderMapper {
        return RequestToKtorHttpRequestBuilderMapper()
    }

    @Provides
    fun provideKtorHttpResponseToResponseMapper(): KtorHttpResponseToResponseMapper {
        return KtorHttpResponseToResponseMapper()
    }

    @Provides
    @Singleton
    fun provideNetworkClient(
        requestMapper: RequestToKtorHttpRequestBuilderMapper,
        responseMapper: KtorHttpResponseToResponseMapper,
        dispatcherProvider: DispatcherProvider,
    ): NetworkClient {
        return NetworkClientImpl(requestMapper, responseMapper, dispatcherProvider)
    }
}
