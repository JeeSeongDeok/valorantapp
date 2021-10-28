package com.example.valorant.data.api.dto.PlayerStore


import com.google.gson.annotations.SerializedName

data class FeaturedTheme(
    @SerializedName("CurrencyID")
    val currencyID: String,
    @SerializedName("DataAssetID")
    val dataAssetID: String,
    @SerializedName("ID")
    val iD: String,
    @SerializedName("Items")
    val items: List<ItemXX>
)