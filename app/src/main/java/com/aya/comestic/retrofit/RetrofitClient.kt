package com.aya.comestic.retrofit

import com.aya.comestic.common_used.AppConst.BASE_URL
import com.aya.comestic.retrofit.utils.ErrorInterceptor
import com.aya.comestic.retrofit.utils.NetworkConnectionInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import com.aya.comestic.BuildConfig;
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitDi {

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl(BASE_URL)
            client(client)
            addConverterFactory(ScalarsConverterFactory.create())
            addConverterFactory(GsonConverterFactory.create(gson))
        }.build()

    }



    @Provides
    @Singleton
    fun provideOkHTTP(
        errorInterceptor: ErrorInterceptor,
        networkConnectionInterceptor: NetworkConnectionInterceptor,
    ): OkHttpClient {

        return OkHttpClient().newBuilder().apply {
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
            connectTimeout(60, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
        }.also{
            it.addInterceptor(errorInterceptor)
            it.addInterceptor(networkConnectionInterceptor)

        }.also {
            val logInterceptor = HttpLoggingInterceptor()
            logInterceptor.level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
            it.addInterceptor(logInterceptor)

        }.build()
    }


    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().setLenient().create()

    }


}