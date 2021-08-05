package com.example.valorant.data.api

import com.example.valorant.data.repository.nameTagData
import com.example.valorant.data.repository.seasonData
import com.example.valorant.data.repository.storeData
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {
    @GET("store")
    fun store(
        @Query("id")id:String,
        @Query("pw")pw:String
    ): Call<List<storeData>>
    @GET("getMain")
    fun getMain(
            @Query("id")id:String,
            @Query("pw")pw:String
    ): Call<seasonData>
    @GET("first_login")
    fun getFirstLogin(
            @Query("id")id:String,
            @Query("pw")pw:String
    ): Call<nameTagData>
}