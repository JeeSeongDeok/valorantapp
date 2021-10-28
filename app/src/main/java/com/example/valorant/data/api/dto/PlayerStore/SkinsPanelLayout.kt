package com.example.valorant.data.api.dto.PlayerStore


import com.google.gson.annotations.SerializedName

data class SkinsPanelLayout(
    @SerializedName("SingleItemOffers")
    val singleItemOffers: List<String>,
    @SerializedName("SingleItemOffersRemainingDurationInSeconds")
    val singleItemOffersRemainingDurationInSeconds: Int
)