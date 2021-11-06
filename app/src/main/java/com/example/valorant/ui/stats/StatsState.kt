package com.example.valorant.ui.stats

import com.example.valorant.model.matchData

data class StatsState(
    val isLoading: Boolean = false,
    val stats: List<matchData>? = null,
    val error: String = ""
)
