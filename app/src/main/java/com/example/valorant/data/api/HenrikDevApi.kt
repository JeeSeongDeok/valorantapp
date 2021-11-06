package com.example.valorant.data.api

import com.example.valorant.model.matchData
import retrofit2.http.GET
import retrofit2.http.Path

interface HenrikDevApi {
    @GET("valorant/v1/by-puuid/mmr-history/kr/{puuid}")
    suspend fun getStats(@Path("puuid") uid: String): List<matchData>
}