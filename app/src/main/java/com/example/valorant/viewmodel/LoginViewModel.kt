package com.example.valorant.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.valorant.Retrofit2.RetrofitBuilder
import com.example.valorant.data.nameTagData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext
    private val prefs: SharedPreferences = context.getSharedPreferences("prefs_name", Context.MODE_PRIVATE)
    companion object {

        const val TAG: String = "로그"
    }
    // ID Live Data
    private val _idLiveData = MutableLiveData<String>()
    val idLiveData: LiveData<String>
        get() = _idLiveData
    // 변경 가는한 Live Data
    private val _resultLiveData = MutableLiveData<Boolean>()
    val resultLiveData: LiveData<Boolean>
        get() = _resultLiveData
    // init 초기값 설정
    init{
        Log.d(TAG, "LoginViewModel - called()")
        // SharedPreferences
        _idLiveData.value = prefs.getString("id", "").toString()
        _resultLiveData.value = false;
    }

    fun connectLogin(id: String, pw: String){
        var connectResult:Boolean = true
        val call = RetrofitBuilder.CONNET_SERVICE
        call.getFirstLogin(id, pw).enqueue(object: Callback<nameTagData>{
            override fun onFailure(call: Call<nameTagData>, t: Throwable) {

            }

            override fun onResponse(call: Call<nameTagData>, response: Response<nameTagData>) {
                Log.e("로그", response.body().toString())
            }

        })
        // connect 성공시
        if(connectResult){
            prefs.edit().putString("id", id).apply()
        }
    }
}