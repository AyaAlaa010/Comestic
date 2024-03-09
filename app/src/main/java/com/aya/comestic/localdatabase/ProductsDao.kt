package com.aya.comestic.localdatabase

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.aya.comestic.common_used.AppConst.PRODUCT_TABLE

interface ProductsDao {

    @Insert
    fun insertProduct(product:ProductEntity)

    @Delete
    fun  deleteProduct(product: ProductEntity)

    @Update
    fun updateProduct(product: ProductEntity)

    @Query("SELECT * FROM $PRODUCT_TABLE")
    fun getAllProducts():List<ProductEntity>


}