package com.aya.comestic.retrofit.utils

import android.content.Context

class CustomExceptions(private val context: Context, code: Int) : RuntimeException() {

    init {
        throw RuntimeException(getCustomHttpException(code))
    }

    private fun getCustomHttpException(code: Int): String {
        when (code) {
            71001 -> return "context.getString(R.string.http_code_400)"
            400 -> return "context.getString(R.string.http_code_400"
            403 -> return "context.getString(R.string.http_code_400)"
            404 -> return "context.getString(R.string.http_code_404)"
            401 -> return "context.getString(R.string.http_code_401)"
            500 -> return "context.getString(R.string.http_code_500)"
            502 -> return "context.getString(R.string.http_code_502)"
            600 -> return "context.getString(R.string.http_code_600)"
            601 -> return "context.getString(R.string.http_code_601)"
            602 -> return "context.getString(R.string.http_code_602)"
            603 -> return " context.getString(R.string.http_code_603)"
            604 -> return "context.getString(R.string.http_code_604)"
            605 -> return " context.getString(R.string.http_code_605)"
            606 -> return "context.getString(R.string.http_code_606)"
            607 -> return "context.getString(R.string.http_code_607)"
            608 -> return "context.getString(R.string.http_code_608)"
            609 -> return "context.getString(R.string.http_code_609)"
            else -> return "Unknown Exception"
        }


    }
}