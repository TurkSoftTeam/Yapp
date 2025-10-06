# Yapp

A modern Android application built with Jetpack Compose and Material3 design system.

## Features

- 🚀 Modern Android architecture with MVVM pattern
- 🎨 Material3 design system with dynamic theming
- 📱 Jetpack Compose UI toolkit
- 🔄 StateFlow for reactive state management
- 🏗️ Gradle Kotlin DSL build system
- 📦 Multi-module architecture ready

## Project Structure

```
app/
├── src/main/
│   ├── java/com/yapp/android/
│   │   ├── MainActivity.kt          # Main app entry point
│   │   ├── MainScreen.kt            # Sample Compose screen
│   │   ├── MainViewModel.kt         # ViewModel with StateFlow
│   │   └── ui/theme/                # Material3 theme configuration
│   ├── res/                         # Android resources
│   └── AndroidManifest.xml          # App manifest
└── build.gradle.kts                 # App module build configuration
```

## Getting Started

1. Clone the repository
2. Open in Android Studio
3. Sync project with Gradle files
4. Run the app on an emulator or device

## Tech Stack

- **Kotlin** - Programming language
- **Jetpack Compose** - Modern toolkit for native UI  
- **Material3** - Latest Material Design components
- **ViewModel** - UI-related data holder, lifecycle conscious
- **StateFlow** - Type-safe reactive state management
- **Android Gradle Plugin 8.1.4** - Build system
- **Roborazzi** - Screenshot testing for Compose UI

## Requirements

- Android Studio Hedgehog or later
- Minimum SDK: 24 (Android 7.0)
- Target SDK: 34 (Android 14)
- Kotlin 1.9.10+

## CI/CD

This project uses GitHub Actions for continuous integration:

- ✅ Automated builds on every PR commit
- ✅ Automated test execution
- ✅ Build reports for debugging failures
- 📸 Automated screenshot generation for Compose UI

### 📸 Viewing Screenshots

After every PR build, screenshots of all Compose screens are automatically generated and uploaded as artifacts. 

**[📖 How to Access Screenshots →](SCREENSHOTS.md)**

See [Branch Protection Configuration](.github/BRANCH_PROTECTION.md) for setting up required status checks to enforce successful builds before merging PRs.
