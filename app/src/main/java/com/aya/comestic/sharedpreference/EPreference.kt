package com.aya.comestic.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import com.aya.comestic.common_used.Common.objectToString

object EPreference {

    val Context.preference: SharedPreferences
        get() = this.getSharedPreferences(
            "preferences",
            Context.MODE_PRIVATE
        )

    fun Context.saveSp(key: String, value: Any) {
        with(this.preference.edit()) {
            when (value) {
                is Boolean -> putBoolean(key, value)
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Float -> putFloat(key, value)
                is Long -> putLong(key, value)
                else -> putString(key, objectToString(value))
            }
            commit()
        }
    }


    inline fun <reified T : Any> Context.loadSp(key: String): T? {// call -->   this.loadSp<String or Int ..etc>(key)
        if (this.preference.contains(key).not()) return null
        val result = when (T::class) {
            Boolean::class -> this.preference.getBoolean(key, false)
            String::class -> this.preference.getString(key, "")
            Int::class -> this.preference.getInt(key, 0)
            Float::class -> this.preference.getFloat(key, 0.0f)
            Long::class -> this.preference.getLong(key, 0)
            else -> throw Exception("Unsupported Type")
        }
        return result as T

    }




    inline fun <reified T : Any> Context.deleteItemSp(key: String) {
        with(this.preference.edit()) {
            when (T::class) {
                Boolean::class -> remove(key)
                String::class -> remove(key)
                Int::class -> remove(key)
                Float::class -> remove(key)
                Long::class -> remove(key)
                else -> remove(key)
            }
            apply()
        }
    }

    fun Context.deleteAllSp()=this.preference.edit().clear().commit()
}





