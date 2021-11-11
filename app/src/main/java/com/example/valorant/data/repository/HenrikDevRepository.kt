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
