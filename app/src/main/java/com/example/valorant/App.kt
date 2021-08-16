package com.example.valorant

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.valorant.utils.PreferenceUtil
import com.example.valorant.utils.ThemUtil

class App : Application() {
    companion object {
        lateinit var prefs : PreferenceUtil
    }
    override fun onCreate() {
        prefs = PreferenceUtil(applicationContext)
        super.onCreate()
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme_Valorant)
        } else {
            setTheme(R.style.Theme_Valorant)
        }
       // AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }
}
