package com.example.valorant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.valorant.databinding.FragmentStatsBinding

class StatsFragment : Fragment(){
    private var mBinding: FragmentStatsBinding? = null
    lateinit var binding: FragmentStatsBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatsBinding.inflate(inflater, container, false)
        mBinding = binding

        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}