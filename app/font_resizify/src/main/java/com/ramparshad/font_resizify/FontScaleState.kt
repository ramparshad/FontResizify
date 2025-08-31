package com.ramparshad.font_resizify

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class FontScaleState(
    initialScale: Float = 1f,
    private val minScale: Float = 0.5f,
    private val maxScale: Float = 2f,
    private val preference: FontScalePreference,
    private val coroutineScope: CoroutineScope
) {
    var scale by mutableStateOf(initialScale.coerceIn(minScale, maxScale))
    val minValue get() = minScale
    val maxValue get() = maxScale

    init {
        // Load the saved scale when initializing
        coroutineScope.launch {
            preference.fontScale.collect { savedScale ->
                scale = savedScale.coerceIn(minScale, maxScale)
            }
        }
    }

    fun updateScale(newScale: Float) {
        scale = newScale.coerceIn(minScale, maxScale)
        // Save the new scale to preferences
        coroutineScope.launch {
            preference.saveFontScale(scale)
        }
    }

    fun reset() {
        updateScale(1f)
    }
}

@Composable
fun rememberFontScaleState(
    minScale: Float = 0.5f,
    maxScale: Float = 2f
): FontScaleState {
    val context = LocalContext.current
    val preference = remember { FontScalePreference(context) }
    val coroutineScope = rememberCoroutineScope()

    // Collect initial scale from preferences
    val initialScale by preference.fontScale.collectAsState(initial = 1f)

    return remember(minScale, maxScale) {
        FontScaleState(
            initialScale = initialScale,
            minScale = minScale,
            maxScale = maxScale,
            preference = preference,
            coroutineScope = coroutineScope
        )
    }
}