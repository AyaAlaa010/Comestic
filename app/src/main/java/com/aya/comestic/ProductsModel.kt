package com.aya.comestic

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductsModel(
 val brand: String? = "",
 val description: String? = "",
 val id: Int,
 val image_link: String? = "",
 val name: String? = "",
 val price: String? = "",
 val price_sign: String ?= "",
) : Parcelable


