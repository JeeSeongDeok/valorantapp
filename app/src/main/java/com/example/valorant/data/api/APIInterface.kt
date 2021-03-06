package com.example.valorant.data.api

import com.example.valorant.data.repository.nameTagData
import com.example.valorant.data.repository.seasonData
import com.example.valorant.data.repository.storeData
import com.example.valorant.model.PlayerStore.StoreTestData
import com.example.valorant.model.matchData
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
    @GET("valorant/v1/by-puuid/mmr-history/kr/{puuid}")
    fun getMMR(
            @Path("puuid") uid: String?,
    ): Call<matchData>
    @GET("store/v2/storefront/{PLAYERID}")
    fun testStore(
            @Path("PLAYERID") playerid: String?,
    ): Call<StoreTestData>
}