package com.example.digdofooddevlivery.data

import androidx.annotation.DrawableRes
import com.example.digdofooddevlivery.R

data class ProductHighlightState (
    val text : String,
    val type: ProductHighlightType
)

enum class ProductHighlightType{
    PRIMARY,SECONDARY
}

data class ProductPreviewState(
    val headline: String = "mr. Chezzy",
    @DrawableRes val productImg: Int = R.drawable.ic_burger,
    val hightlights: List<ProductHighlightState> = listOf(
        ProductHighlightState(
            text ="Classic Taste",
            type = ProductHighlightType.SECONDARY
        ),
        ProductHighlightState(
            text ="Bastseller",
            type = ProductHighlightType.PRIMARY
        ),
    )
)