package com.example.valorant.data.api.dto.PlayerStore


import com.google.gson.annotations.SerializedName

data class ItemXXX(
    @SerializedName("Amount")
    val amount: Int,
    @SerializedName("ItemID")
    val itemID: String,
    @SerializedName("ItemTypeID")
    val itemTypeID: String
)