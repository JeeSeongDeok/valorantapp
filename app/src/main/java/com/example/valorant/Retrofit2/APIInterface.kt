package com.example.valorant.Retrofit2

import com.example.valorant.data.storeData
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {
    @GET("store")
    fun store(
        @Query("id")id:String,
        @Query("pw")pw:String
    ): Call<List<storeData>>

    @GET("api/v1/authorization")
    @Headers("X-Forwarded-For: ")
    fun riotToken()
}