package com.example.valorant.model.PlayerStore


import com.google.gson.annotations.SerializedName

data class ItemXX(
    @SerializedName("BasePrice")
    val basePrice: Int,
    @SerializedName("CurrencyID")
    val currencyID: String,
    @SerializedName("DiscountPercent")
    val discountPercent: Int,
    @SerializedName("IsPromoItem")
    val isPromoItem: Boolean,
    @SerializedName("Item")
    val item: ItemXXX
)