package com.example.digdofooddevlivery.ui.screen.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import com.example.digdofooddevlivery.data.Calories
import com.example.digdofooddevlivery.data.NutritionState
import com.example.digdofooddevlivery.data.ProductNutritionState
import com.example.digdofooddevlivery.ui.theme.AppTheme

@Composable
fun ProductNutritionSection(
    modifier: Modifier = Modifier,
    state: ProductNutritionState
) {
    Column(modifier =modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
        SectionHeader(
            title ="Nutrition facts",
            calories =state.calories,
            )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier =modifier.fillMaxWidth()
        )
        {
            state.nutrition.onEach { item -> NutritionItem(state = item)}
        }
    }
}

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    title : String,
    calories : Calories
) {
   Row(
       modifier =modifier.fillMaxWidth(),
       horizontalArrangement = Arrangement.SpaceBetween,
       verticalAlignment = Alignment.CenterVertically
   ){
       Text(
           text = title,
           style = AppTheme.Typography.titleLarge,
           color = AppTheme.colors.onBackground
       )
       Row(
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.spacedBy(4.dp)
       ){
           Text(
               text = calories.value,
               style = AppTheme.Typography.titleMedium,
               color = AppTheme.colors.onBackground
           )
           Text(
               text = calories.unit,
               style = AppTheme.Typography.titleMedium,
               color = AppTheme.colors.onBackground
           )
       }
   }

}

@Composable
private fun NutritionItem(
    modifier: Modifier = Modifier,
    state: NutritionState
) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row (
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = state.amount,
                style = AppTheme.Typography.titleMedium,
                fontWeight = FontWeight.Light,
                color = AppTheme.colors.onBackground
            )
            Text(
                text = state.unit,
                style = AppTheme.Typography.titleMedium,
                fontWeight = FontWeight.Light,
                color = AppTheme.colors.onBackground
            )
        }
        Text(
            text = state.title,
            style = AppTheme.Typography.label,
            color = AppTheme.colors.onBackground
        )
    }
    
}