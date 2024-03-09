package com.aya.comestic.localdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aya.comestic.common_used.AppConst.PRODUCT_TABLE

@Entity(tableName = PRODUCT_TABLE)
data class ProductEntity (
    @PrimaryKey(autoGenerate = true) val id:Int ,
    val name:String,
    val price:Double,
    val imageUrl :String
)