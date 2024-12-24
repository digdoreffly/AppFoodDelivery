package com.example.digdofooddevlivery.data

import androidx.annotation.DrawableRes
import com.example.digdofooddevlivery.R

data class ProductFlavorState(
    val name :String,
    val price :String,
    @DrawableRes val imgRes: Int
)

val ProductFlavorData = listOf(
    ProductFlavorState(
        imgRes = R.drawable.ic_cheese,
        name = "Chedder",
        price = "Rp 10.000"

    ),

    ProductFlavorState(
        imgRes = R.drawable.ic_beef,
        name = "beef",
        price = "Rp 20.000"
    ),

    ProductFlavorState(
        imgRes = R.drawable.ic_onion,
        name = "onion",
        price = "Rp 10.ooo"
    )

)