package com.ramparshad.font_resizify

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf


val LocalFontScale = compositionLocalOf {  }

@Composable
fun FontSliderProvider(
    minScale: Float = 0.5f,
    maxScale: Float = 2f,
    content: @Composable () -> Unit
) {
    val fontScaleState = rememberFontScaleState(minScale, maxScale)

    CompositionLocalProvider(
        LocalFontScale provides fontScaleState.scale,
        content = content
    )
}
