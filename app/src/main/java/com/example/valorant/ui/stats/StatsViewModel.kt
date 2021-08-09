package com.example.valorant.ui.stats

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.valorant.App
import com.example.valorant.di.RetrofitBuilder
import com.example.valorant.model.matchList
import com.example.valorant.model.matchData

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatsViewModel : ViewModel() {
    // 통신에서 받을 mmr을 LiveData로 설정
    private val _mmrLiveData = MutableLiveData<MutableList<matchList>>()
    val mmrLiveData: MutableLiveData<MutableList<matchList>>
        get() = _mmrLiveData

    init{
        // 초기화
        _mmrLiveData.value = ArrayList()
    }
    fun getMMR(){
        val call = RetrofitBuilder.connect_henrikdev
        val uid = App.prefs.getString("uid", "")
        // uid가 저장안된다면 종료
        if(uid == "")
            return

        // uid로 통신
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
    }
}