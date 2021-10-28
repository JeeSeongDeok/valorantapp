package com.example.valorant.data.api

import com.example.valorant.data.repository.nameTagData
import com.example.valorant.data.repository.storeData
import com.example.valorant.model.matchData
import retrofit2.Call
import retrofit2.http.*

interface MyStoreApi {
    @GET("store")
    suspend fun store(
        @Query("id")id:String,
        @Query("pw")pw:String
    ): Call<List<storeData>>
    @GET("first_login")
    suspend fun getFirstLogin(
            @Query("id")id:String,
            @Query("pw")pw:String
    ): Call<nameTagData>
}