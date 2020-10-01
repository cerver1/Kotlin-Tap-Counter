package com.fair.counter1234

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class SharedPreferences(context: Context?) {

    private val defaultPreferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)
    private val editor = defaultPreferences.edit()

    /**
    fun isFirstRun() = defaultPreferences.getBoolean("FIRST_TIME", true)
    fun setFirstRun() {
    editor.putBoolean("FIRST_TIME", false)
    editor.apply()
    }
     */

    fun getIncrementalCount() = defaultPreferences.getInt("IncrementalCount", 0)
    fun setIncrementalCount(value: Int) {
        editor.putInt("IncrementalCount", value)
        editor.apply()
    }

    fun getDecrementalCount() = defaultPreferences.getInt("DecrementalCount", 100)
    fun setDecrementalCount(value: Int) {
        editor.putInt("DecrementalCount", value)
        editor.apply()
    }

    val get = { KEY_NAME: String -> defaultPreferences.getString(KEY_NAME, "") }

}