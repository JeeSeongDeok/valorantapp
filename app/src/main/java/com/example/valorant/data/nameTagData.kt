package com.example.valorant.data

import com.google.gson.annotations.SerializedName

data class nameTagData (
        @SerializedName("game_name")
        var name: String? = null,
        @SerializedName("tag_line")
        var tag: String? = null
)
