package com.example.valorant.model.PlayerStore


import com.google.gson.annotations.SerializedName

data class ItemX(
    @SerializedName("Amount")
    val amount: Int,
    @SerializedName("ItemID")
    val itemID: String,
    @SerializedName("ItemTypeID")
    val itemTypeID: String
)