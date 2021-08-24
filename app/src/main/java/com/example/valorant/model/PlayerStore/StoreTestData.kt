package com.example.valorant.model.PlayerStore


import com.google.gson.annotations.SerializedName

data class StoreTestData(
    @SerializedName("FeaturedBundle")
    val featuredBundle: FeaturedBundle,
    @SerializedName("FeaturedTheme")
    val featuredTheme: FeaturedTheme,
    @SerializedName("SkinsPanelLayout")
    val skinsPanelLayout: SkinsPanelLayout
)