package com.example.valorant.ui.setting


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



import androidx.fragment.app.Fragment

import com.example.valorant.databinding.FragmentSettingBinding
import com.example.valorant.ui.main.MainActivity
import com.example.valorant.utils.ThemUtil

class SettingFragment : Fragment() {
    private var mBinding: FragmentSettingBinding? = null
    lateinit var binding: FragmentSettingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSettingBinding.inflate(inflater, container, false)
        mBinding = binding

        // 다크모드 설정
        setDarkMode()
        return mBinding?.root
    }

    fun setDarkMode(){
        binding.darkModeSwitch.setOnCheckedChangeListener{CompoundButton, onSwitch ->
            if(onSwitch){
                ThemUtil.applyTheme(ThemUtil.ThemeMode.DARK)
                activity?.let{
                    val nextIntent = Intent(context, MainActivity::class.java)
                    startActivityForResult(nextIntent, 101)
                }
            }
            else{
                ThemUtil.applyTheme(ThemUtil.ThemeMode.LIGHT)
            }
        }
    }
}