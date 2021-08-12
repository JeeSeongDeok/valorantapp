package com.example.valorant.ui.stats

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorant.App
import com.example.valorant.data.repository.MatchRepository
import com.example.valorant.data.repository.MatchRepositoryImpl
import com.example.valorant.di.RetrofitBuilder
import com.example.valorant.model.matchList
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


open class StatsViewModel : ViewModel() {
    // repository
    val matchRepository by lazy{
        MatchRepositoryImpl()
    }
    // 통신에서 받을 데이터를 LiveData로 설정
    private var _mmrLiveData = MutableLiveData<MutableList<matchList>>()
    val mmrLiveData: MutableLiveData<MutableList<matchList>>
        get() = _mmrLiveData
    // Progressbar 설정
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: MutableLiveData<Boolean>
        get() = _isLoading
    init{
        // 초기화
        _mmrLiveData.value = ArrayList()
        _isLoading.value = false
    }
    // API 연결
    fun getMMR(){
        // 프로그래스바 실행
        doLoading()
        viewModelScope.launch {
            val statsLiveData:MutableLiveData<List<matchList>> = matchRepository.getStats() as MutableLiveData<List<matchList>>
            withContext(Main){
                _mmrLiveData = statsLiveData as MutableLiveData<MutableList<matchList>>
            }
        }
        doneLoading()
    }
    private fun doLoading(){
        _isLoading.value = true
    }
    private fun doneLoading(){
        _isLoading.value = false
    }
}