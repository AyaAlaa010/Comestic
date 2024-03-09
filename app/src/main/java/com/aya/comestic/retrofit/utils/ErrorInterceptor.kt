package com.aya.comestic.retrofit.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class ErrorInterceptor @Inject constructor(@ApplicationContext val context: Context):Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request=chain.request()
        val response=chain.proceed(request)
        if(response.isSuccessful.not()){
            throw CustomExceptions(context,response.code)
        }

        val builder: Request.Builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }
}