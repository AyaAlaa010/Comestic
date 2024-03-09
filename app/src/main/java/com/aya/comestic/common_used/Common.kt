package com.aya.comestic.common_used

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.aya.comestic.R
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import kotlin.reflect.KClass

object Common{

    fun objectToString(obj: Any?): String? {
        val gson = Gson()
        var encoded: String? = null
        try {
            encoded = gson.toJson(obj).toString()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return encoded
    }

    fun <T:Any> stringToObject(string: String?, type: KClass<T>): T? {
        val gson = Gson()
        var obj: T? = null
        try {
            obj = gson.fromJson(string, type.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return obj
    }

    fun showSnackBar(view : View, message:String){
        val snack = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
        snack.show()
    }


    fun showImage(imageLink:String, imageView: ImageView, context: Context){
        Glide.with(context)
            .load(imageLink)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageView)
    }

}