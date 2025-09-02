<h1 align="center">FontResizify 🎚️✨</h1>
<p align="center">
  <b>A Jetpack Compose library for dynamic font scaling with DataStore persistence.</b><br/>
  Drop-in replacement for Compose's <code>Text</code> with slider-based scaling.  
</p>

<p align="center">
  <a href="https://jitpack.io/#YourGitHubUser/FontResizify"><img src="https://jitpack.io/v/YourGitHubUser/FontResizify.svg" alt="JitPack"></a>
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


















