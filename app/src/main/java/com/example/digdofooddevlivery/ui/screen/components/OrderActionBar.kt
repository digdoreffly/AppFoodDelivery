package com.example.digdofooddevlivery.ui.screen.components

import android.graphics.Color
import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Icon

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.digdofooddevlivery.R
import com.example.digdofooddevlivery.data.OrderState
import com.example.digdofooddevlivery.ui.theme.AppTheme

@Composable
fun OrderActionBar(
    modifier: Modifier = Modifier,
    onAddItemCliked: () -> Unit,
    onRemoveItemCliked: () -> Unit,
    onCheckOutCliked: () -> Unit,
    state: OrderState,

    ) {
    Surface(
        modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        color =AppTheme.colors.surface,
        contentColor    = AppTheme.colors.onSurface,
        shadowElevation = 16.dp

    ){
        Row(
            modifier= modifier
                .padding(8.dp)
                .height(76.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            ){
            Selector(
                amount = state.amount,
                onAddItemCliked = onAddItemCliked,
                onRemoveItemCliked = onRemoveItemCliked,
                modifier = Modifier.weight(weight = 1f)
            )
            Cart(
                totalPrice =state.totalPrice,
                onCliked = onCheckOutCliked,
                modifier = Modifier.weight(weight = 1f)
                )
        }
    }
}

@Composable
fun Selector(
    modifier: Modifier = Modifier,
    amount: Int ,
    onAddItemCliked: () -> Unit,
    onRemoveItemCliked: () -> Unit
) {
     Box(
         modifier = modifier
             .fillMaxSize()
             .border(
                 width = 1.dp,
                 color = AppTheme.colors.secondarySurface,
                 shape = RoundedCornerShape(20.dp)
             ),
         contentAlignment = Alignment.Center

     ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement =Arrangement.spacedBy(16.dp),
        ){
            SelectorButton(
                iconRes = R.drawable.ic_minus,
                contentColor =AppTheme.colors.actionSurface,
                containerColor = AppTheme.colors.actionSurface,
                onCliked = onRemoveItemCliked
            )

            Text(
                text= amount.toString(),
                color = AppTheme.colors.onSurface,
                style = AppTheme.Typography.titleLarge
            )

            SelectorButton(
                iconRes = R.drawable.ic_plus,
                contentColor =AppTheme.colors.onSecondarySurface,
                containerColor = AppTheme.colors.secondarySurface,
                onCliked = onAddItemCliked)
        }
     }

}

@Composable
fun SelectorButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int,
    containerColor: androidx.compose.ui.graphics.Color, // Menggunakan androidx.compose.ui.graphics.Color
    contentColor: androidx.compose.ui.graphics.Color,
    onCliked: () -> Unit
) {
    Surface(
        modifier = modifier.size(24.dp),
        shape = CircleShape,
        color = containerColor, // Gunakan `color` untuk background color di Surface
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable(onClick = onCliked), // Ganti `onCliked` menjadi `onClick`
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                tint = contentColor, // Set contentColor di Icon
                modifier = Modifier.size(7.dp)
            )
        }
    }
}

@Composable
private fun Cart(
    modifier: Modifier = Modifier,
    totalPrice: String,
    onCliked: () -> Unit
) {
    Surface(
        modifier = modifier.clickable(onClick = onCliked),
        color = AppTheme.colors.secondarySurface,
        contentColor = AppTheme.colors.secondarySurface,
        shape = RoundedCornerShape(20.dp)
        ){
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Add To Cart",
                    style = AppTheme.Typography.titleSmall,
                )

                Text(
                    text = totalPrice,
                    style = AppTheme.Typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}