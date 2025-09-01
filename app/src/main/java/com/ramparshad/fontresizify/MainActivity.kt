package com.ramparshad.fontresizify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramparshad.font_resizify.FontSliderControl
import com.ramparshad.font_resizify.FontSliderControlColors
import com.ramparshad.font_resizify.FontSliderControlSizes
import com.ramparshad.font_resizify.FontSliderProvider
import com.ramparshad.font_resizify.Orientation
import com.ramparshad.font_resizify.ResizableText
import com.ramparshad.fontresizify.ui.theme.FontResizifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FontResizifyTheme {
                FontResizifyDemo()
            }
        }
    }
}

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(),
        typography = MaterialTheme.typography,
        content = content
    )
}

@Composable
fun FontResizifyDemo() {
    FontSliderProvider {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ResizableText(
                text = "FontResizify Demo",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 16.dp),
                fontSlider = true
            )

            FontSliderControl(
                modifier = Modifier.fillMaxWidth(),
                minScale = 0.7f,
                maxScale = 1.5f,

                colors = FontSliderControlColors(
                    cardColor = Color(0xFFE3F2FD),
                    cardBorderColor = Color(0xFF2F373B),
                    textColor = Color(0xFF1565C0),
                    buttonColor = Color(0xFF5BD251),
                    buttonTextColor = Color.White,
                    sliderColor = Color(0xFF6BA6C9),
                    sliderTrackColor = Color(0xFFBF1F00)
                ),

                sizes = FontSliderControlSizes(
                    cardElevation = 4.dp,
                    cardBorderWidth = 2.dp,
                    cardPadding = 24.dp,
                    spacing = 12.dp,
                    buttonHeight = 38.dp
                ),
                orientation = Orientation.Vertical,

                showPercentage = true,
                showMinMaxLabels = false,
                showResetButton = true

            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "This is a heading that scales",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(vertical = 8.dp),

            )


            ResizableText(
                text = "This is body text that also scales with the slider. Notice how all text with fontSlider=true responds to the font size adjustment.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(vertical = 8.dp),
                fontSlider = true
            )

            ResizableText(
                text = "This text doesn't scale (fontSlider=false)",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp),
                fontSlider = true
            )

            ResizableText(
                text = "Another scaling text with different style",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp),
                fontSlider = false
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun jhgd(modifier: Modifier = Modifier) {
    FontResizifyDemo()
}