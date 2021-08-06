package com.example.valorant.data.repository

import com.google.gson.annotations.SerializedName

data class nameTagData (
        @SerializedName("game_name")
        var name: String? = null,
        @SerializedName("tag_line")
        var tag: String? = null,
        @SerializedName("userinfo")
        var uid: String? = null
)
