package com.fair.counter1234

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(context: Context) {

        private val PRIVATE_MODE = 0
        private val PREF_NAME = "initVal"
        private val sharedPrefs: SharedPreferences = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE)

        fun save(Key:String,data:String){
            val editor: SharedPreferences.Editor = sharedPrefs.edit()
            editor.putString(Key,data)
            editor.apply()
        }
        fun retrieve(Key: String):String?{
            return sharedPrefs.getString(Key, null)
        }
}