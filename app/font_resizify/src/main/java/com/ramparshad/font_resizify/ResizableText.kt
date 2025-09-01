package com.ramparshad.font_resizify

import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun ResizableText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current,
    fontSlider: Boolean = false
) {
    val fontScale = LocalFontScale.current

    val baseFontSize = if (fontSize != TextUnit.Unspecified) {
        fontSize
    } else if (style.fontSize != TextUnit.Unspecified) {
        style.fontSize
    } else {
        14.sp
    }

    val baseLineHeight = if (lineHeight != TextUnit.Unspecified) {
        lineHeight
    } else if (style.lineHeight != TextUnit.Unspecified) {
        style.lineHeight
    } else {
        TextUnit.Unspecified
    }

    // Apply scaling if enabled
    val scaledFontSize = if (fontSlider) {
        (baseFontSize.value * fontScale).sp
    } else {
        baseFontSize
    }

    val scaledLineHeight = if (fontSlider && baseLineHeight != TextUnit.Unspecified) {
        (baseLineHeight.value * fontScale).sp
    } else {
        baseLineHeight
    }

    // Create the final style
    val finalStyle = style.merge(
        TextStyle(
            color = if (color != Color.Unspecified) color else style.color,
            fontSize = scaledFontSize,
            fontWeight = fontWeight ?: style.fontWeight,
            textAlign = textAlign ?: style.textAlign,
            lineHeight = scaledLineHeight,
            fontFamily = fontFamily ?: style.fontFamily,
            textDecoration = textDecoration ?: style.textDecoration,
            fontStyle = fontStyle ?: style.fontStyle,
            letterSpacing = if (letterSpacing != TextUnit.Unspecified) letterSpacing else style.letterSpacing
        )
    )

    androidx.compose.material3.Text(
        text = text,
        modifier = modifier,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
        style = finalStyle
    )
}