package com.example.valorant.ui.setting


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window


import androidx.fragment.app.Fragment
import com.example.valorant.App
import com.example.valorant.R

import com.example.valorant.databinding.FragmentSettingBinding
import com.example.valorant.ui.main.MainActivity
import com.example.valorant.utils.ThemUtil

class SettingFragment : Fragment() {
    private var mBinding: FragmentSettingBinding? = null
    lateinit var binding: FragmentSettingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSettingBinding.inflate(inflater, container, false)
        mBinding = binding
        // switchUI 설정
        setSwitch()
        // 다크모드 설정
        setMode()
        return mBinding?.root
    }
    private fun setSwitch(){
        binding.darkModeSwitch.isChecked = App.prefs.getString("mode", "light") == "dark"
    }
    // 스위치를 누르면 다크모드 혹은 라이트 모드가 발생
    private fun setMode(){
        binding.darkModeSwitch.setOnCheckedChangeListener{CompoundButton, onSwitch ->
            if(onSwitch){
                onDarkMode()
            }
            else{
                onLightMode()
            }
        }

    }

    private fun onDarkMode(){
        App.prefs.setString("mode", "dark")
        ThemUtil.applyTheme(ThemUtil.ThemeMode.DARK)
        (activity as MainActivity).recreate()
    //(activity as MainActivity).refresh()
    }

    private fun onLightMode(){
        App.prefs.setString("mode", "light")
        ThemUtil.applyTheme(ThemUtil.ThemeMode.LIGHT)
        (activity as MainActivity).refresh()
    }
}