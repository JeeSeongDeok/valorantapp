package com.example.valorant.data.repository


import com.example.valorant.data.api.HenrikDevApi
import com.example.valorant.domain.reposiotry.HenrikDevRepository
import com.example.valorant.model.matchData
import com.example.valorant.model.matchList
import javax.inject.Inject

class HenrikDevRepositoryImpl @Inject constructor(
    private val api: HenrikDevApi
) : HenrikDevRepository {
    override suspend fun getStats(uid: String): List<matchData> {
        return api.getStats(uid)
    }
}

// 이전 소스
//class MatchRepositoryImpl : MatchRepository{
//    var playerMatchData: MutableLiveData<List<matchList>> = MutableLiveData<List<matchList>>()
//    init{
//        val call = RetrofitBuilder.CONNECT___HENRIKDEV
//        val uid = App.prefs.getString("uid", "")
//        // API 연결 시작
//        call.getMMR(uid).enqueue(object: Callback<matchData>{
//            override fun onFailure(call: Call<matchData>, t: Throwable) {
//                // stats: 500
//                Log.e("로그", "에러: $t")
//            }
//            override fun onResponse(call: Call<matchData>, response: Response<matchData>) {
//                if(response.isSuccessful){
//                    // stats 200
//                    Log.e("로그", "결과: " + response.body().toString())
//                    playerMatchData.value = response.body()?.data
//                }
//                else{
//                    // code 400
//                }
//            }
//        })
//    }
//    override suspend fun getStats(): LiveData<List<matchList>> {
//        return playerMatchData
//    }
//}