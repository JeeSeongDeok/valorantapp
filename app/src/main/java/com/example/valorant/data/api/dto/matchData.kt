package com.example.valorant.model

data class matchData(
        var status: String? = null,
        var data:List<matchList>? = null,
)
data class matchList(
        var currenttier: Int? = null,
        var currenttierpatched:String? = null,
        var ranking_in_tier:Int? = null,
        var mmr_change_to_last_game:Int? = null,
        var elo:Int? = null,
        var date:String? = null,
        var date_raw:String? = null
)


//{
//    "status": "200",
//    "name": "Unkn0wN",
//    "tag": "11111",
//    "data": [
//    {
//        "currenttier": 21,
//        "currenttierpatched": "Immortal",
//        "ranking_in_tier": 90,
//        "mmr_change_to_last_game": 20,
//        "elo": 1890,
//        "date": "Friday, August 6, 2021 10:51 AM",
//        "date_raw": 1628261469262
//    },
//    {
//        "currenttier": 21,
//        "currenttierpatched": "Immortal",
//        "ranking_in_tier": 70,
//        "mmr_change_to_last_game": 23,
//        "elo": 1870,
//        "date": "Friday, August 6, 2021 10:22 AM",
//        "date_raw": 1628259745763
//    },
//    {
//        "currenttier": 21,
//        "currenttierpatched": "Immortal",
//        "ranking_in_tier": 47,
//        "mmr_change_to_last_game": -12,
//        "elo": 1847,
//        "date": "Friday, August 6, 2021 9:47 AM",
//        "date_raw": 1628257677595
//    },
//    {
//        "currenttier": 21,
//        "currenttierpatched": "Immortal",
//        "ranking_in_tier": 59,
//        "mmr_change_to_last_game": 22,
//        "elo": 1859,
//        "date": "Thursday, August 5, 2021 10:49 AM",
//        "date_raw": 1628174960198
//    },
//    {
//        "currenttier": 21,
//        "currenttierpatched": "Immortal",
//        "ranking_in_tier": 37,
//        "mmr_change_to_last_game": 3,
//        "elo": 1837,
//        "date": "Thursday, August 5, 2021 10:00 AM",
//        "date_raw": 1628172021003
//    }
//    ]
//}
//
