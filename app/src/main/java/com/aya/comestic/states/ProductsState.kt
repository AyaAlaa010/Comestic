package com.aya.comestic.states

import com.aya.comestic.beans.ProductsBeans

sealed class ProductsState(
    val message: String? = "",
    val products: ArrayList<ProductsBeans>? = null,
) {

    object Idle : ProductsState()
    object ProductInProgress : ProductsState()
    object ProductsInRequestSend : ProductsState()
    class ProductsInSuccessful(products: ArrayList<ProductsBeans>) : ProductsState(products = products)
    class ProductsInFailure(message: String) : ProductsState(message = message)


}