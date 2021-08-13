package com.example.valorant.ui.stats

import android.util.Log
import androidx.lifecycle.LiveData
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
    private val matchRepository by lazy{
        MatchRepositoryImpl()
    }
    // 통신에서 받을 데이터를 LiveData로 설정
    private var _mmrLiveData = MutableLiveData<List<matchList>>()
    val mmrLiveData: LiveData<List<matchList>>
        get() = _mmrLiveData
    // Progressbar 설정
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: MutableLiveData<Boolean>
        get() = _isLoading
    init{
        _isLoading.value = false
        _mmrLiveData = matchRepository.playerMatchData
    }
    // API 연결
    fun getMMR(){

        // 프로그래스바 실행
        doLoading()


        doneLoading()
    }
    private fun doLoading(){
        _isLoading.value = true
    }
    private fun doneLoading(){
        _isLoading.value = false
    }
}