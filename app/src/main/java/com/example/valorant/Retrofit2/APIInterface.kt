package com.example.valorant.Retrofit2

import com.example.valorant.data.*
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