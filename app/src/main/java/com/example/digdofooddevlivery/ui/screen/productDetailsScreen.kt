package com.example.digdofooddevlivery.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.digdofooddevlivery.data.OrderState
import com.example.digdofooddevlivery.data.ProductDescriptionData
import com.example.digdofooddevlivery.data.ProductFlavorData
import com.example.digdofooddevlivery.data.ProductFlavorState
import com.example.digdofooddevlivery.data.ProductNutrionData
import com.example.digdofooddevlivery.data.ProductNutritionState
import com.example.digdofooddevlivery.data.ProductPreviewState
import com.example.digdofooddevlivery.data.oderData
import com.example.digdofooddevlivery.ui.screen.components.FlavorSection
import com.example.digdofooddevlivery.ui.screen.components.OrderActionBar
import com.example.digdofooddevlivery.ui.screen.components.ProductDescriptionSection
import com.example.digdofooddevlivery.ui.screen.components.ProductNutritionSection
import com.example.digdofooddevlivery.ui.screen.components.ProductPreviewSection



@Composable
fun ProductDetailsScreen(
    modifier: Modifier = Modifier,
    ProductPreviewState: ProductPreviewState = ProductPreviewState(),
    ProductFlavors :List<ProductFlavorState> = ProductFlavorData,
    ProductNutritionState: ProductNutritionState  = ProductNutrionData,
    ProductDescription: String = ProductDescriptionData,
    orderState: OrderState = oderData,
    onAddItemCliked: () -> Unit,
    onRemoveItemCliked: () -> Unit,
    onCheckOutCliked: () -> Unit,

){
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,

    ){
    Content(
        ProductPreviewState = ProductPreviewState,
        ProductFlavors= ProductFlavors,
        ProductNutritionState = ProductNutritionState,
        ProductDescription = ProductDescription
    )
        OrderActionBar(
            state = orderState,
            onAddItemCliked=onAddItemCliked,
            onRemoveItemCliked = onRemoveItemCliked,
            onCheckOutCliked = onCheckOutCliked,
            modifier = Modifier.
            navigationBarsPadding()
                .padding(
                    horizontal = 18.dp,
                    vertical = 8.dp,
                )

        )
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    ProductPreviewState: ProductPreviewState,
    ProductFlavors :List<ProductFlavorState>,
    ProductNutritionState: ProductNutritionState ,
    ProductDescription: String,

) {
    val scrollableState = rememberScrollState ()

    Column(
        modifier = modifier.verticalScroll(scrollableState)
    ){
        ProductPreviewSection(
            state = ProductPreviewState
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        FlavorSection(
            modifier = Modifier.padding(18.dp),
            data = ProductFlavors)

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        ProductNutritionSection(
            modifier = Modifier.padding(18 .dp),
            state = ProductNutritionState

        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        ProductDescriptionSection(
            productDescription = ProductDescription,
            modifier = modifier
                .navigationBarsPadding()
                .padding(horizontal = 18.dp)
                .padding(bottom = 128.dp)

        )
    }
}