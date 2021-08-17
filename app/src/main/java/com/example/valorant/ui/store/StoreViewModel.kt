package com.example.valorant.ui.store

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.valorant.di.RetrofitBuilder
import com.example.valorant.data.repository.storeData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StoreViewModel: ViewModel() {
    // 수정가능한 데이터
    private val _resultLiveData = MutableLiveData<List<storeData>>()
    val resultLiveData: MutableLiveData<List<storeData>>
        get() = _resultLiveData

    init{

    }
    fun Connect(id:String, pw:String){
        Log.d("로그", "콜 ")
        val call = RetrofitBuilder.CONNET_SERVICE

        call.store(id, pw).enqueue(object : Callback<List<storeData>>{
            override fun onFailure(call: Call<List<storeData>>, t: Throwable) {
                // 실패
                Log.e("로그", "실패 에러: ${t.message}")
            }

            override fun onResponse(call: Call<List<storeData>>, response: Response<List<storeData>>) {
                Log.d("로그", "결과: " + response.body())
                _resultLiveData.value = response.body()
            }

        })
    }
}