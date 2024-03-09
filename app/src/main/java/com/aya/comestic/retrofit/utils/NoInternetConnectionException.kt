package com.aya.comestic.retrofit.utils

import java.io.IOException

class NoInternetConnectionException():IOException() {
    override val message: String?
        get() = "No Internet Connection"
}