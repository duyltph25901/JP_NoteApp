@file:Suppress("UNCHECKED_CAST")

package com.example.noteapp.data.local.cache

import android.content.Context
import android.content.SharedPreferences

object SharedUtils {
    private const val PREFERENCES_NAME = "NoteApp"

    private var sharePref: SharedPreferences? = null

    fun init(context: Context) {
        if (sharePref == null) {
            sharePref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        }
    }

    fun setValue(keyName: String, value: Any?) {
        val editor = sharePref?.edit()
        when (value) {
            is Int -> editor?.putInt(keyName, value)
            is Float -> editor?.putFloat(keyName, value)
            is Long -> editor?.putLong(keyName, value)
            is Boolean -> editor?.putBoolean(keyName, value)
            is String -> editor?.putString(keyName, value)
        }
        editor?.apply()
    }

    fun <T> getValue(keyName: String, defaultValue: T): T = when (defaultValue) {
        is Int -> (sharePref?.getInt(keyName, defaultValue) ?: defaultValue) as T
        is Long -> (sharePref?.getLong(keyName, defaultValue) ?: defaultValue) as T
        is Float -> (sharePref?.getFloat(keyName, defaultValue) ?: defaultValue) as T
        is Boolean -> (sharePref?.getBoolean(keyName, defaultValue) ?: defaultValue) as T
        is String -> (sharePref?.getString(keyName, defaultValue) ?: defaultValue) as T
        else -> defaultValue
    }

    var valueDemo: Int
        get() = getValue("demo_key_value", 0)
        set(value) = setValue("demo_key_value", value)

}