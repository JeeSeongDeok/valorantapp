package com.example.valorant.ui.stats

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.valorant.App
import com.example.valorant.di.RetrofitBuilder
import com.example.valorant.model.matchList
import com.example.valorant.model.matchData
import okhttp3.internal.notify

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatsViewModel : ViewModel() {
    // 통신에서 받을 데이터를 LiveData로 설정
    private val _mmrLiveData = MutableLiveData<MutableList<matchList>>()
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
        val call = RetrofitBuilder.connect_henrikdev
        val uid = App.prefs.getString("uid", "")
        // 서버로 보낼 데이터가 존재하지 않으면 종료
        if(uid == "")
            return
        // 프로그래스바 실행
        doLoading()
        // API 연결 시작
        call.getMMR(uid).enqueue(object: Callback<matchData>{
            override fun onFailure(call: Call<matchData>, t: Throwable) {
                // stats: 500
                Log.e("로그", "에러: $t")
            }
            override fun onResponse(call: Call<matchData>, response: Response<matchData>) {
                if(response.isSuccessful){
                    // stats 200
                    Log.e("로그", "결과: " + response.body().toString())
                    _mmrLiveData.value = response.body()?.data as MutableList<matchList>?
                }
                else{
                    // code 400
                }
            }
        })
        // 프로그래스바 종료
        doneLoading()
    }
    private fun doLoading(){
        _isLoading.value = true
    }
    private fun doneLoading(){
        _isLoading.value = false
    }
}