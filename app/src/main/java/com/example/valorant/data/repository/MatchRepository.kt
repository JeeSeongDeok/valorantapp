package com.example.valorant.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.valorant.App
import com.example.valorant.di.RetrofitBuilder
import com.example.valorant.model.matchData
import com.example.valorant.model.matchList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface MatchRepository{
    suspend fun getStats(): LiveData<List<matchList>>
}

class MatchRepositoryImpl : MatchRepository{
    var playerMatchData: MutableLiveData<List<matchList>> = MutableLiveData<List<matchList>>()
    init{
        val call = RetrofitBuilder.connect_henrikdev
        val uid = App.prefs.getString("uid", "")
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
                    playerMatchData.value = response.body()?.data 
                }
                else{
                    // code 400
                }
            }
        })
    }
    override suspend fun getStats(): LiveData<List<matchList>> {
        return playerMatchData
    }
}