# Expected Screenshot Output

This document shows what you can expect from the automated screenshot generation.

## 📸 Generated Screenshots

After each PR build, the following screenshots will be available in the `composable-screenshots` artifact:

### 1. HomeScreen.png
**Screen**: Main home screen of the app
**Contains**:
- App title: "Welcome to YAPP"
- Star icon (Material Design)
- Welcome message
- Bottom navigation with three buttons:
  - Explore (Home icon)
  - Search (Search icon)
  - Ask (Info icon)
- Logout button in the top-right corner

**Preview Function**: `MeditationLessonsScreenPreview()`
**File**: `app/src/main/java/com/yapp/android/ui/screens/HomeScreen.kt`

---

### 2. LoginScreen.png
**Screen**: User authentication screen
**Contains**:
- "Sign in" heading
- Username text field (enabled)
- Password text field (masked, enabled)
- "Remember me" checkbox
- Login button (primary style)
- "Forgot Password?" link (gray)
- "Don't have an Account? Sign up" link (primary color)

**Preview Function**: `LoginScreenPreview()`
**File**: `app/src/main/java/com/yapp/android/ui/screens/LoginScreen.kt`

---

### 3. MainScreen.png
**Screen**: Sample screen with counter
**Contains**:
- "Yapp" app name (headline style)
- "Welcome to Yapp!" subheading
- Counter display showing "Counter: 0"
- "Increment Counter" button

**Preview Function**: `MainScreenPreview()`
**File**: `app/src/main/java/com/yapp/android/MainScreen.kt`

---

## 📐 Screenshot Specifications

- **Format**: PNG (Portable Network Graphics)
- **Color Space**: sRGB
- **Background**: White (from `showBackground = true` in @Preview)
- **Theme**: Material3 with Yapp theme
- **SDK Level**: 33 (Android 13)
- **Test Framework**: Robolectric 4.11.1
- **Capture Tool**: Roborazzi 1.7.0

## 📁 File Structure in Artifact

```
composable-screenshots.zip
├── app/
│   ├── src/test/screenshots/
│   │   ├── HomeScreen.png          ← Main screenshot output
│   │   ├── LoginScreen.png         ← Main screenshot output
│   │   └── MainScreen.png          ← Main screenshot output
│   └── build/outputs/roborazzi/
│       └── (test execution artifacts and metadata)
```

## 🎨 Visual Characteristics

All screenshots will show:
- Material3 design components
- Dynamic color theming (if applicable)
- Proper spacing and padding as defined in the layouts
- Material icons from the Icons library
- Typography following Material3 guidelines

## 🔄 When Screenshots are Generated

Screenshots are generated:
1. ✅ On every pull request (opened, synchronized, reopened)
2. ✅ After successful build and test execution
3. ✅ Even if screenshot generation has warnings (continue-on-error: true)
4. ✅ Uploaded as artifacts regardless of overall workflow status (if: always())

## 📊 Expected File Sizes

Approximate sizes (may vary):
- HomeScreen.png: ~50-150 KB
- LoginScreen.png: ~40-120 KB
- MainScreen.png: ~30-100 KB
- Total artifact size: ~150-500 KB (compressed)

## 🧪 Testing Verification

Each screenshot test verifies:
- ✅ Composable can be rendered without crashes
- ✅ Theme is applied correctly
- ✅ All UI elements are visible
- ✅ Layout structure matches the preview definition

## 💡 Tips for Reviewing Screenshots

1. **Visual Regression**: Compare with previous versions to spot unintended changes
2. **Cross-Platform**: Screenshots are rendered on a standardized environment (CI)
3. **Documentation**: Use screenshots in documentation and design reviews
4. **Accessibility**: Check for proper contrast and text sizes
5. **Consistency**: Ensure Material3 design guidelines are followed

## 🚨 Common Issues

**If screenshots look wrong:**
- Check if theme colors are correctly defined
- Verify Material3 dependencies are up to date
- Ensure @Preview annotations use correct parameters
- Check Robolectric configuration in `robolectric.properties`

**If screenshots are missing:**
- Check GitHub Actions logs for test failures
- Verify Roborazzi plugin is properly applied
- Ensure test dependencies are correctly specified
- Check that screenshot tests are in the correct source set (`src/test/`)

---

For questions or issues, refer to [SCREENSHOTS.md](SCREENSHOTS.md) or [QUICKSTART_SCREENSHOTS.md](QUICKSTART_SCREENSHOTS.md).
