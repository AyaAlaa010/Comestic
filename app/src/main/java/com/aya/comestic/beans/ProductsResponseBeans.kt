package com.aya.comestic.beans

import android.os.Parcelable
import com.aya.comestic.ProductsModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductsBeans(
    val api_featured_image: String,
    val brand: String,
    val category: String,
    val created_at: String,
    val currency: String,
    val description: String,
    val id: Int,
    val image_link: String,
    val name: String,
    val price: String,
    val price_sign: String,
    val product_api_url: String,
    val product_colors: List<ProductColorBeans>,
    val product_link: String,
    val product_type: String,
    val rating: Double,
    val tag_list: List<String>,
    val updated_at: String,
    val website_link: String,
) : Parcelable

@Parcelize
data class ProductColorBeans(
    val colour_name: String,
    val hex_value: String,
) : Parcelable


fun ProductsBeans.toProductsModels(): ProductsModel {
    return ProductsModel(
        brand = brand,
        description = description,
        id = id,
        image_link = image_link,
        name = name,
        price = price,
        price_sign = price_sign
    )

}









