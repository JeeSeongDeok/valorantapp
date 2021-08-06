package com.example.valorant

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.valorant.utils.PreferenceUtil

class App : Application() {
    companion object {
        lateinit var prefs : PreferenceUtil
    }
    override fun onCreate() {
        prefs = PreferenceUtil(applicationContext)
        super.onCreate()
       // AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }
}
