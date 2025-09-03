<h1 align="center">FontResizify 🎚️✨</h1>
<p align="center">
  <b>A Jetpack Compose library for dynamic font scaling with DataStore persistence.</b><br/>
  Drop-in replacement for Compose's <code>Text</code> with slider-based scaling.  
</p>

<p align="center">
  <a href="https://jitpack.io/#RamParshad/FontResizify"><img src="https://jitpack.io/v/RamParshad/FontResizify.svg" alt="JitPack"></a>
  <a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/License-MIT-green.svg" alt="License: MIT"></a>
  <img src="https://img.shields.io/badge/Jetpack%20Compose-✓-blue" alt="Jetpack Compose">
  <img src="https://img.shields.io/badge/Android-27+-brightgreen" alt="Android">
</p>

---

## 🚀 Introduction

**FontResizify** makes your app’s text scalable with just one property!  
It’s a **drop-in replacement** for Compose’s `Text()` that allows users to **increase or decrease font size dynamically** via a slider, with persistence using **DataStore**.  

Perfect for accessibility, user personalization, or simply giving more control to your users. 🎉

---

https://github.com/user-attachments/assets/1099d53e-e92c-4a5e-8b02-5a9ccc289e7d

## ✨ Features

- 🎚️ **Dynamic font scaling** with a global slider  
- 💾 **DataStore persistence** to save user preferences  
- 🔄 **Drop-in replacement** for Compose’s `Text()`  
- 🎨 Works with **Material 3** and custom typography  
- 📱 Compatible with **Android 27+**  
- ⚡ Lightweight & easy integration  

---

## 📦 Installation

Add **JitPack** to your `settings.gradle`:

```gradle
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url "https://jitpack.io" }
    }
}
```

## Add Dependency

```
dependencies {
	        implementation ("com.github.ramparshad:FontResizify:1.0.1")
	}
```

## 🚀 Quick Start

### 1. Wrap Your App with Provider

```
@Composable
fun MyApp() {
    FontSliderProvider {
        MyScreen()        // Your app content
    }
}
```

### 2. Use ResizableText for Scalable Content

```
import com.ramparshad.font_resizify.ResizableText

@Composable
fun MyScreen() {
    Column {
        // This text will scale with the slider
        ResizableText(
            text = "Scalable Heading",
            fontSlider = true,
            style = MaterialTheme.typography.headlineMedium
        )
        
        // This text won't scale
        ResizableText(
            text = "Static text",
            fontSlider = false
        )
        
        // You can still use default Text component
        Text(
            text = "Regular Compose Text",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
```

### 3. Add Slider Control 

```
@Composable
fun MyScreen() {
    Column {
        // Other content here
        
        // Add slider control
        FontSliderControl()
    }
}
```

## 🎨 Customization Examples

### 📖 Custom Colors and Layout

```
FontSliderControl(
    colors = FontSliderControlColors(
        cardColor = Color(0xFFE3F2FD),
        cardBorderColor = Color(0xFF2196F3),
        textColor = Color(0xFF1565C0),
        buttonColor = Color(0xFF2196F3),
        buttonTextColor = Color.White,
        sliderColor = Color(0xFF2196F3),
        sliderTrackColor = Color(0xFFBBDEFB)
    ),
    orientation = Orientation.Horizontal,
    resetButtonText = "Reset"
)
```

### 📖 Minimalist Slider

```
FontSliderControl(
    showPercentage = false,
    showMinMaxLabels = false,
    showResetButton = false
)
```

### 📖 Compact Design

```
FontSliderControl(
    sizes = FontSliderControlSizes(
        cardElevation = 4.dp,
        cardPadding = 12.dp,
        spacing = 6.dp,
        buttonHeight = 36.dp
    )
)
```

### 📖 Custom Scale Range

```
FontSliderProvider(
    minScale = 0.8f,   // 80% minimum
    maxScale = 1.8f    // 180% maximum
) {
    // other content here
}
```

###  📖 ResizableText Parameters

```
ResizableText(
    text: String,                    // Text to display
    modifier: Modifier = Modifier,   // Layout modifier
    color: Color = Color.Unspecified,// Text color
    fontSize: TextUnit = TextUnit.Unspecified, // Font size
    fontStyle: FontStyle? = null,    // Font style (normal, italic)
    fontWeight: FontWeight? = null,  // Font weight
    fontFamily: FontFamily? = null,  // Font family
    letterSpacing: TextUnit = TextUnit.Unspecified, // Letter spacing
    textDecoration: TextDecoration? = null, // Text decoration
    textAlign: TextAlign? = null,    // Text alignment
    lineHeight: TextUnit = TextUnit.Unspecified, // Line height
    overflow: TextOverflow = TextOverflow.Clip, // Overflow handling
    softWrap: Boolean = true,        // Soft wrap
    maxLines: Int = Int.MAX_VALUE,   // Maximum lines
    onTextLayout: (TextLayoutResult) -> Unit = {}, // Layout callback
    style: TextStyle = LocalTextStyle.current, // Text style
    fontSlider: Boolean = false      // Enable scaling (REQUIRED)
)
```

###  🤝 Contributing
We welcome contributions! Please feel free to submit pull requests or open issues for bugs and feature requests.

## 📜 License

This library is licensed under the MIT License.  
See the [LICENSE](./LICENSE) file for details.











