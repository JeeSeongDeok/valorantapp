package com.example.valorant.ui.stats

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.valorant.App
import com.example.valorant.databinding.FragmentStatsBinding
import com.example.valorant.model.matchList
import com.example.valorant.ui.loading.LoadingDialog
import com.example.valorant.ui.stats.adapter.RecyclerAdapterMatch
import com.example.valorant.utils.ChangerankUtil
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive


class StatsFragment : Fragment(){
    private lateinit var matchAdapter : RecyclerAdapterMatch
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
        // 로딩창 옵저빙
        loadingLiveDataObserver()
        // 랭크매치 기록 옵저빙
        mmrLiveDataObserver()
        // connect
        model.getMMR()
        return mBinding?.root
    }
    // mmrLiveData 옵저버
    private fun mmrLiveDataObserver() {
        // 해당 아이디의 전적 데이터를 가져옴
        model.mmrLiveData.observe(viewLifecycleOwner){
            if(it != null && it.isNotEmpty()) {
                // 랭크부분 UI 업데이트
                initRank(it[0])
                // 상세 전적정보 (승패, ELO 떨어진거)
                initRecycler(it)
            }
        }
    }
    // loadingLiveData 옵저버
    private fun loadingLiveDataObserver(){
        // Progressbar에 대한 정보를 관찰
        model.isLoading.observe(viewLifecycleOwner){
            Log.e("로그", "StatsFragment - 로딩값: $it")
            // 로딩창을 띄우라고하면
            if(it){
                showLoading()
            }
            // 로딩창 띄우지 말라고 하면
            else if(it){
                dismissLoading()
            }
        }
    }
    private fun showLoading() = LoadingDialog(requireContext()).show()
    private fun dismissLoading() = LoadingDialog(requireContext()).dismiss()
    // 랭크 섹션 UI 세팅
    private fun initRank(latelyMatchDate:matchList){
        // UI Setting
        binding.statsPlayerRank.text = ChangerankUtil.getRank(latelyMatchDate.currenttier!!)
        binding.statsPlayerElo.text = " " + latelyMatchDate.ranking_in_tier!!.toString() + "RP"
        binding.statsTitle.text = App.prefs.getString("name", "닉네임을 불러올 수 없습니다") + "#" +App.prefs.getString("tag", "태그를 불러올 수 없습니다")
        // 랭크 아이콘 로드
        Glide.with(this)
                .load(ChangerankUtil.getRankIcon(latelyMatchDate.currenttier!!))
                .into(binding.statsRankImageView)
    }

    private fun initRecycler(items: List<matchList>){
        matchAdapter = RecyclerAdapterMatch(requireContext())
        binding.statsDetailInfo.adapter = matchAdapter
        matchAdapter.data = items as MutableList<matchList>
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}