package com.example.valorant.model

data class PlayerStoreData(
    val FeaturedBundle: FeaturedBundle,
    val FeaturedTheme: FeaturedTheme,
    val SkinsPanelLayout: SkinsPanelLayout
)

data class SkinsPanelLayout(
        val SingleItemOffers: List<String>,
        val SingleItemOffersRemainingDurationInSeconds: Int
)


data class ItemXXX(
        val Amount: Int,
        val ItemID: String,
        val ItemTypeID: String
)

data class ItemXX(
        val BasePrice: Int,
        val CurrencyID: String,
        val DiscountPercent: Int,
        val IsPromoItem: Boolean,
        val Item: ItemXXX
)

data class ItemX(
        val Amount: Int,
        val ItemID: String,
        val ItemTypeID: String
)

data class Item(
        val BasePrice: Int,
        val CurrencyID: String,
        val DiscountPercent: Int,
        val IsPromoItem: Boolean,
        val Item: ItemX
)
data class FeaturedBundle(
        val Bundle: Bundle,
        val BundleRemainingDurationInSeconds: Int
)
data class Bundle(
        val CurrencyID: String,
        val DataAssetID: String,
        val ID: String,
        val Items: List<Item>
)
data class FeaturedTheme(
        val CurrencyID: String,
        val DataAssetID: String,
        val ID: String,
        val Items: List<ItemXX>
)