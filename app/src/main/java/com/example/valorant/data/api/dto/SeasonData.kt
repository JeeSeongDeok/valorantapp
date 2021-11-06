package com.example.valorant.data.repository

data class seasonData(
        val SeasonID:String?= null,
        val NumberOfWins:Int?= null,
        val NumberOfWinsWithPlacements:Int?=null,
        val NumberOfGames:Int? = null,
        val Rank:Int? = null,
        val CapstoneWins:Int? = null,
        val LeaderboardRank:Int? = null,
        val CompetitveTier:Int? = null,
        val RankedRating:Int? = null,
        val GamesneededForRating:Int? = null,
        val TotalWinsNeededForRank:Int? = null
)