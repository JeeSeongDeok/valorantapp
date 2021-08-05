package com.example.valorant.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.valorant.R
import com.example.valorant.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeFragment : Fragment(), View.OnClickListener{
    private var mBinding: FragmentHomeBinding? = null
    lateinit var binding: FragmentHomeBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        mBinding = binding
        // 리스너를 설정한다
        setListener()
        return mBinding?.root
    }
    fun setListener(){
        // 카드뷰 리스너 세팅
        binding.homeStatsCardView.setOnClickListener(this)
        binding.homeStoreCardView.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v){
            binding.homeStatsCardView -> {
                // MainActivity의 BottomNav를 불러 Stats를 선택
                (requireActivity().findViewById<View>(R.id.myBottomNav) as BottomNavigationView).selectedItemId = R.id.statsFragment
            }
            binding.homeStoreCardView -> {
                // MainActivity의 BottomNav를 불러 Store를 선택
                (requireActivity().findViewById<View>(R.id.myBottomNav) as BottomNavigationView).selectedItemId = R.id.storeFragment
            }
        }
    }
    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}