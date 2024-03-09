package com.aya.comestic.endpoints

import com.aya.comestic.beans.ProductsBeans
import retrofit2.Response
import retrofit2.http.GET

interface ProductsEndPoint {
//http://makeup-api.herokuapp.com/api/v1/products.json

    @GET("/api/v1/products.json")
    suspend fun getProducts():Response<ArrayList<ProductsBeans>>


}