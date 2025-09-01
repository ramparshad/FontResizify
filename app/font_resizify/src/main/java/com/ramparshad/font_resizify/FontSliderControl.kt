package com.ramparshad.font_resizify

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Only holds colors, no composable calls here
data class FontSliderControlColors(
    val cardColor: Color,
    val cardBorderColor: Color,
    val textColor: Color,
    val buttonColor: Color,
    val buttonTextColor: Color,
    val sliderColor: Color,
    val sliderTrackColor: Color
)

// Factory function to get default theme-based colors
@Composable
fun defaultFontSliderControlColors() = FontSliderControlColors(
    cardColor = MaterialTheme.colorScheme.surface,
    cardBorderColor = MaterialTheme.colorScheme.outline,
    textColor = MaterialTheme.colorScheme.onSurface,
    buttonColor = MaterialTheme.colorScheme.primary,
    buttonTextColor = MaterialTheme.colorScheme.onPrimary,
    sliderColor = MaterialTheme.colorScheme.primary,
    sliderTrackColor = MaterialTheme.colorScheme.primaryContainer
)

data class FontSliderControlSizes(
    val cardElevation: Dp = 8.dp,
    val cardBorderWidth: Dp = 1.dp,
    val cardPadding: Dp = 16.dp,
    val spacing: Dp = 8.dp,
    val buttonHeight: Dp = 40.dp
)

@Composable
fun FontSliderControl(
    modifier: Modifier = Modifier,
    minScale: Float = 0.5f,
    maxScale: Float = 2f,
    colors: FontSliderControlColors = defaultFontSliderControlColors(),
    sizes: FontSliderControlSizes = FontSliderControlSizes(),
    shape: Shape = MaterialTheme.shapes.medium,
    orientation: Orientation = Orientation.Vertical,
    showPercentage: Boolean = true,
    showMinMaxLabels: Boolean = true,
    showResetButton: Boolean = true,
    resetButtonText: String = "Reset Size"
) {
    val fontScaleState = rememberFontScaleState(minScale, maxScale)

    if (orientation == Orientation.Vertical) {
        VerticalSliderControl(
            fontScaleState = fontScaleState,
            modifier = modifier,
            minScale = minScale,
            maxScale = maxScale,
            colors = colors,
            sizes = sizes,
            shape = shape,
            showPercentage = showPercentage,
            showMinMaxLabels = showMinMaxLabels,
            showResetButton = showResetButton,
            resetButtonText = resetButtonText
        )
    } else {
        HorizontalSliderControl(
            fontScaleState = fontScaleState,
            modifier = modifier,
            minScale = minScale,
            maxScale = maxScale,
            colors = colors,
            sizes = sizes,
            shape = shape,
            showPercentage = showPercentage,
            showMinMaxLabels = showMinMaxLabels,
            showResetButton = showResetButton,
            resetButtonText = resetButtonText
        )
    }
}

@Composable
private fun VerticalSliderControl(
    fontScaleState: FontScaleState,
    modifier: Modifier = Modifier,
    minScale: Float = 0.5f,
    maxScale: Float = 2f,
    colors: FontSliderControlColors,
    sizes: FontSliderControlSizes,
    shape: Shape,
    showPercentage: Boolean,
    showMinMaxLabels: Boolean,
    showResetButton: Boolean,
    resetButtonText: String
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = sizes.cardElevation),
        shape = shape,
        colors = CardDefaults.cardColors(containerColor = colors.cardColor),
        border = BorderStroke(sizes.cardBorderWidth, colors.cardBorderColor)
    ) {
        Column(
            modifier = Modifier.padding(sizes.cardPadding)
        ) {
            if (showPercentage) {
                ResizableText(
                    text = "Font Size: ${(fontScaleState.scale * 100).toInt()}%",
                    fontWeight = FontWeight.Bold,
                    color = colors.textColor
                )
                Spacer(modifier = Modifier.height(sizes.spacing))
            }

            Slider(
                value = fontScaleState.scale,
                onValueChange = { fontScaleState.updateScale(it) },
                valueRange = minScale..maxScale,
                steps = ((maxScale - minScale) / 0.1f).toInt() - 1,
                colors = SliderDefaults.colors(
                    thumbColor = colors.sliderColor,
                    activeTrackColor = colors.sliderColor,
                    inactiveTrackColor = colors.sliderTrackColor
                )
            )

            if (showMinMaxLabels) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ResizableText(text = "${(minScale * 100).toInt()}%", color = colors.textColor)
                    ResizableText(text = "${(maxScale * 100).toInt()}%", color = colors.textColor)
                }
            }

            if (showResetButton) {
                Spacer(modifier = Modifier.height(sizes.spacing))
                Button(
                    onClick = { fontScaleState.reset() },
                    modifier = Modifier
                        .align(Alignment.End)
                        .height(sizes.buttonHeight),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colors.buttonColor,
                        contentColor = colors.buttonTextColor
                    )
                ) {
                    ResizableText(text = resetButtonText, color = colors.buttonTextColor)
                }
            }
        }
    }
}

@Composable
private fun HorizontalSliderControl(
    fontScaleState: FontScaleState,
    modifier: Modifier = Modifier,
    minScale: Float = 0.5f,
    maxScale: Float = 2f,
    colors: FontSliderControlColors,
    sizes: FontSliderControlSizes,
    shape: Shape,
    showPercentage: Boolean,
    showMinMaxLabels: Boolean,
    showResetButton: Boolean,
    resetButtonText: String
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = sizes.cardElevation),
        shape = shape,
        colors = CardDefaults.cardColors(containerColor = colors.cardColor),
        border = BorderStroke(sizes.cardBorderWidth, colors.cardBorderColor)
    ) {
        Row(
            modifier = Modifier.padding(sizes.cardPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                if (showPercentage) {
                    ResizableText(
                        text = "Font Size: ${(fontScaleState.scale * 100).toInt()}%",
                        fontWeight = FontWeight.Bold,
                        color = colors.textColor
                    )
                    Spacer(modifier = Modifier.height(sizes.spacing))
                }

                Slider(
                    value = fontScaleState.scale,
                    onValueChange = { fontScaleState.updateScale(it) },
                    valueRange = minScale..maxScale,
                    steps = ((maxScale - minScale) / 0.1f).toInt() - 1,
                    colors = SliderDefaults.colors(
                        thumbColor = colors.sliderColor,
                        activeTrackColor = colors.sliderColor,
                        inactiveTrackColor = colors.sliderTrackColor
                    )
                )

                if (showMinMaxLabels) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        ResizableText(text = "${(minScale * 100).toInt()}%", color = colors.textColor)
                        ResizableText(text = "${(maxScale * 100).toInt()}%", color = colors.textColor)
                    }
                }
            }

            if (showResetButton) {
                Spacer(modifier = Modifier.width(sizes.spacing))
                Button(
                    onClick = { fontScaleState.reset() },
                    modifier = Modifier.height(sizes.buttonHeight),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colors.buttonColor,
                        contentColor = colors.buttonTextColor
                    )
                ) {
                    ResizableText(text = resetButtonText, color = colors.buttonTextColor)
                }
            }
        }
    }
}

enum class Orientation {
    Vertical, Horizontal
}
