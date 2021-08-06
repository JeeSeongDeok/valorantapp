package com.example.valorant.ui.stats

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.valorant.databinding.FragmentStatsBinding
import com.example.valorant.model.mmrList
import com.example.valorant.utils.ChangerankUtil


class StatsFragment : Fragment(){
    private var mBinding: FragmentStatsBinding? = null
    lateinit var binding: FragmentStatsBinding
    private val model: StatsViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // 바인딩 세팅
        binding = FragmentStatsBinding.inflate(inflater, container, false)
        mBinding = binding
        // 리스너 세팅
        setListener()
        // mmr 옵저빙
        model.mmrLiveData.observe(viewLifecycleOwner){
            it?.let{
                // 랭크이름
                var rankName: String? = it.currenttier?.let { it1 -> ChangerankUtil.getRank(it1) }
                binding.statsRankTitle.text = rankName
                // 랭크 ELO포인트
                binding.statsPlayerElo.text = it.ranking_in_tier.toString()
                // 랭크 이미지 설정
                val url:String = "https://media.valorant-api.com/competitivetiers/edb72a72-7e6d-6010-9591-7c053bbdbf48/" + it.currenttier.toString() +"/largeicon.png"
                Glide.with(this)
                    .load(url)
                    .into(binding.statsRankImageView)
            }
        }

        return mBinding?.root
    }

    fun setListener(){
//        mBinding?.statsTextInputLayout?.setEndIconOnClickListener {
//            it.setOnClickListener {
//                model.getMMR()
//                Log.e("로그", "검색")
//            }
//        }
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}