package com.example.valorant.ui.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.valorant.App
import com.example.valorant.di.RetrofitBuilder
import com.example.valorant.data.repository.nameTagData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel(application: Application) : AndroidViewModel(application) {
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
        _idLiveData.value = App.prefs.getString("id", "")
        _resultLiveData.value = false;
    }

    fun connectLogin(id: String, pw: String){
        val call = RetrofitBuilder.CONNET_SERVICE
        call.getFirstLogin(id, pw).enqueue(object: Callback<nameTagData>{
            override fun onFailure(call: Call<nameTagData>, t: Throwable) {
                // 응답코드 500
                Log.e(TAG, "Login failed")
                // 연결실패
                _resultLiveData.value = false
            }

            override fun onResponse(call: Call<nameTagData>, response: Response<nameTagData>) {
                // 응답코드 200
                if(response.isSuccessful){
                    // 아이디 기억하기 버튼을 눌럿을 경우
                    App.prefs.setString("id", id)
                    // 닉네임과 태그를 저장하기 위해서
                    App.prefs.setString("name", response.body()?.name.toString())
                    App.prefs.setString("tag", response.body()?.tag.toString())
                    App.prefs.setString("uid", response.body()?.uid.toString())
                    // connect를 성공, activity가 관찰하고 있기 때문에 값 변경
                    _resultLiveData.value = true
                }
                // 응답코드 400
                else{
                    // 연결 실패
                    _resultLiveData.value = false
                }
            }
        })
    }
}