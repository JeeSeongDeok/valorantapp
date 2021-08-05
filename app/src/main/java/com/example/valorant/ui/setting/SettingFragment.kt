package com.example.valorant.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.valorant.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    private var mBinding: FragmentSettingBinding? = null
    lateinit var binding: FragmentSettingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSettingBinding.inflate(inflater, container, false)
        mBinding = binding

        return mBinding?.root
    }
}