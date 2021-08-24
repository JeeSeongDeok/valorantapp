package com.example.valorant.model.PlayerStore


import com.google.gson.annotations.SerializedName

data class FeaturedBundle(
    @SerializedName("Bundle")
    val bundle: Bundle,
    @SerializedName("BundleRemainingDurationInSeconds")
    val bundleRemainingDurationInSeconds: Int
)