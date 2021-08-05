package com.example.valorant.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("prefs_name", Context.MODE_PRIVATE)
    // Key를 통해 String을 불러옴
    fun getString(key: String, defValue: String): String { return prefs.getString(key, defValue).toString() }
    // Key에 String 값을 저장
    fun setString(key: String, str: String) { prefs.edit().putString(key, str).apply() }
}