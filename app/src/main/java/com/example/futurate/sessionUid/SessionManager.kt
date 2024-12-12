package com.example.futurate.sessionUid

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("app_pref", Context.MODE_PRIVATE)

    fun saveUid(uid: String) {
        sharedPreferences.edit().putString("uid", uid).apply()
    }

    fun getUid(): String? {
        return sharedPreferences.getString("uid", null)
    }

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}