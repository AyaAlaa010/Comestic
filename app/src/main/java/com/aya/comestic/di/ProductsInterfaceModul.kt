package com.aya.comestic.di

import com.aya.comestic.endpoints.ProductsEndPoint
import com.aya.comestic.retrofit.RetrofitDi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = [RetrofitDi::class])
@InstallIn(SingletonComponent::class)
class ProductsInterfaceModule {
    @Singleton
    @Provides
    fun provideRegistrationApi (retrofit: Retrofit): ProductsEndPoint {
        return retrofit.create(ProductsEndPoint::class.java)
    }
}