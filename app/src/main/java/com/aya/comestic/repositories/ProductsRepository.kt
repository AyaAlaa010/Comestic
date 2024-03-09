package com.aya.comestic.repositories

import android.util.Log
import com.aya.comestic.endpoints.ProductsEndPoint
import com.aya.comestic.retrofit.DataState
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductsRepository @Inject constructor( val ProductsEndPoint: ProductsEndPoint) {

fun sayHello():String =  "hello"

     fun getProducts() = flow {
        Log.i("Homeeeeeeeee", "repo:  loading")

        emit(DataState.Loading())

        try {
            Log.i("Homeeeeeeeee", "repo:  loading")

            val response = ProductsEndPoint.getProducts()
            if (response.isSuccessful && response.code() == 200) {
                Log.i("Homeeeeeeeee", "repo :  success")

                emit(DataState.Success(response.body()))
            } else {
                Log.i("Homeeeeeeeee", "repo:  error")

                emit(DataState.Error( response.message().toString(),null))
            }
        } catch (ex: Exception) {
            Log.i("Homeeeeeeeee", "repo :  exception")

            emit(DataState.Error( ex.localizedMessage.toString() ?: "Some thing went wrong",null))
            ex.printStackTrace()
        }


    }
}