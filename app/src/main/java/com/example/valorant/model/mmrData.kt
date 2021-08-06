package com.example.valorant.model

data class mmrData(
        var status: String? = null,
        var data:mmrList? = null,
)
data class mmrList(
        var currenttier: Int? = null,
        var currenttierpatched:String? = null,
        var ranking_in_tier:Int? = null,
        var mmr_change_to_last_game:Int? = null,
        var elo:Int? = null,
        var name:String? = null,
        var tag:String? = null
)
