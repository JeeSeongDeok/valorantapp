package com.example.valorant.ui.stats

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.valorant.App
import com.example.valorant.databinding.FragmentStatsBinding
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
        // connect
        model.getMMR()
        // 리스너 세팅
        setListener()
        // 랭크매치 기록 옵저빙
        model.mmrLiveData.observe(viewLifecycleOwner){
            if(it.isNotEmpty()) {
                // 첫번째 매치 데이터로 간단한 인포 생성
                val rankName: String? = it[0].currenttier?.let { it1 -> ChangerankUtil.getRank(it1) }
                val elo: Int? = it[0].ranking_in_tier
                val mmr: Int? = it[0].elo
                val lastMatch: String? = it[0].date
                var url: String = "https://media.valorant-api.com/competitivetiers/edb72a72-7e6d-6010-9591-7c053bbdbf48/"
                // 21 ~ 23은 불멸 1 2 3이 불멸 3으로 통합되어서, 불멸 3으로 고정 그 외는 랭크에 맞게 표시
                if (it[0].currenttier!! !in 21..23) {url += it[0].currenttier.toString() + "largeicon.png"} else {url += "23/largeicon.png"}
                // UI Setting
                binding.statsPlayerRank.text = rankName
                binding.statsPlayerElo.text = " " + elo.toString() + "RP"
                binding.statsTitle.text = App.prefs.getString("name", "닉네임을 불러올 수 없습니다") + "#" +App.prefs.getString("tag", "태그를 불러올 수 없습니다")
                Glide.with(this)
                        .load(url)
                        .into(binding.statsRankImageView)
                // 상세 전적정보 (승패, ELO 떨어진거)
                for (i in it) {
                    val tier: Int? = i.currenttier
                    val elo: Int? = i.ranking_in_tier
                    var date: String? = i.date
                    val mmr: Int? = i.elo
                    // UI 세팅하면 될 듯

                }
            }
        }
        return mBinding?.root
    }

    fun dateFormat(date:String){
        var splitDate = date.split(",").toMutableList()
        var translationDate:String = ""
        // 영어로 된 요일을 변경
        when(splitDate[0]){
            "Monday" -> splitDate[0] = "월요일"
            "Tuesday" -> splitDate[0] = "화요일"
            "Wednesday" -> splitDate[0] = "수요일"
            "Thursday" -> splitDate[0] = "목요일"
            "Firday" -> splitDate[0] = "금요일"
            "Saturday" -> splitDate[0] = "토요일"
            "Sunday" -> splitDate[0] = "일요일"
        }
        // 달 변경
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