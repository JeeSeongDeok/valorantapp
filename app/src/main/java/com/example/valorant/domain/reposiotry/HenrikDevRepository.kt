package com.example.valorant.domain.reposiotry

import com.example.valorant.model.matchData

interface HenrikDevRepository {
    suspend fun getStats(uid: String): List<matchData>
}