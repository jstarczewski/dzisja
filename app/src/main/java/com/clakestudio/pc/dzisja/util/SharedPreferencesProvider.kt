package com.clakestudio.pc.dzisja.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

object SharedPreferencesProvider {

    fun getDefaultSharedPreferences(context: Context): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }

    operator fun SharedPreferences.set(key: String, value: Any?) {
        when (value) {
            is String -> edit { it.putString(key, value) }
            is Int -> edit { it.putInt(key, value) }
            is Boolean -> edit { it.putBoolean(key, value) }
            else -> throw UnsupportedOperationException("Wrong type")
        }
    }

    inline operator fun <reified T : Any> SharedPreferences.get(key: String, defaultValue: T? = null): T? {
        return when (T::class) {
            String::class -> getString(key, defaultValue as String) as T?
            Int::class -> getInt(key, defaultValue as Int) as T?
            Boolean::class -> getBoolean(key, defaultValue as Boolean) as T?
            else -> throw UnsupportedOperationException("Wrong type")
        }

    }

}