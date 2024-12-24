package com.example.digdofooddevlivery.ui.screen.components


import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.digdofooddevlivery.data.ProductHighlightState
import com.example.digdofooddevlivery.data.ProductHighlightType
import com.example.digdofooddevlivery.ui.theme.AppTheme
@Composable
fun ProductHighlights(
    modifier: Modifier = Modifier,
    highlights: List<ProductHighlightState>
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        highlights.forEach { item ->
            Highlight(
                text = item.text,
                colors = HighlightDefaults.colors(type = item.type)
            )
        }
    }
}

@Composable
private fun Highlight(
    modifier: Modifier = Modifier,
    text: String,
    colors: HighlightColor = HighlightDefaults.defaultColor
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(percent = 50),
        contentColor = colors.contentColor,
        color = colors.containerColor // Use 'color' if 'containerColor' is not available
    ) {
        Box(
            modifier = modifier
                .padding(
                    vertical = 10.dp,
                    horizontal = 12.dp
                )
        ) {
            Text(
                text = text,
                style = AppTheme.Typography.titleSmall,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

private object HighlightDefaults {
    val defaultColor = HighlightColor(
        contentColor = Color.Unspecified,
        containerColor = Color.Unspecified
    )

    @Composable
    fun colors(type: ProductHighlightType): HighlightColor = when (type) {
        ProductHighlightType.PRIMARY -> HighlightColor(
            containerColor = AppTheme.colors.highlightSurface,
            contentColor = AppTheme.colors.onHighlightSurface
        )
        ProductHighlightType.SECONDARY -> HighlightColor(
            containerColor = AppTheme.colors.actionSurface,
            contentColor = AppTheme.colors.onActionSurface
        )
    }
}

@Immutable
private data class HighlightColor(
    val containerColor: Color,
    val contentColor: Color,
)