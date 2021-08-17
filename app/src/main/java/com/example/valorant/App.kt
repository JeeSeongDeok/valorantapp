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
        // 사용자 모드 확인
        setMode()
        super.onCreate()
    }
    fun setMode(){
        if(prefs.getString("mode", "light") == "dark")
            ThemUtil.applyTheme(ThemUtil.ThemeMode.DARK)
        else
            ThemUtil.applyTheme(ThemUtil.ThemeMode.LIGHT)
    }
}
