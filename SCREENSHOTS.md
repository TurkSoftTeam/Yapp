# Viewing Composable Screen Screenshots

This document explains how to view the automatically generated screenshots of our Jetpack Compose screens.

## 📸 Overview

After every pull request build, our GitHub Actions workflow automatically generates screenshots of all composable screens with `@Preview` annotations. These screenshots help visualize the UI changes and ensure consistency.

## 🎯 How to Access Screenshots

### Method 1: Download from GitHub Actions Artifacts

1. **Navigate to the Pull Request**
   - Go to your PR on GitHub
   - Click on the "Checks" tab at the top

2. **Find the Workflow Run**
   - Look for "Android Build Check" workflow
   - Click on it to see the details

3. **Download Screenshots**
   - Scroll down to the "Artifacts" section at the bottom
   - Click on "composable-screenshots" to download
   - Extract the ZIP file to view PNG screenshots

### Method 2: Direct from Actions Tab

1. Go to the [Actions tab](../../actions) in the repository
2. Click on "Android Build Check" workflow
3. Select the most recent run
4. Scroll to the "Artifacts" section
5. Download "composable-screenshots"

## 📱 Current Screenshots

The following screens are automatically captured:

- **HomeScreen** - Main application screen with welcome message and menu
- **LoginScreen** - User authentication screen with username/password fields
- **MainScreen** - Sample screen with counter functionality

## 🔧 Technical Details

### Screenshot Generation

- **Tool**: [Roborazzi](https://github.com/takahirom/roborazzi) - A screenshot testing library for Jetpack Compose
- **Test Framework**: Robolectric (runs on JVM, no emulator needed)
- **Format**: PNG images
- **Location**: Screenshots are saved to `app/build/outputs/roborazzi/` during build

### Workflow Configuration

Screenshots are generated using:
```bash
./gradlew recordRoborazziDebug
```

The workflow is configured with:
- `continue-on-error: true` - Ensures screenshot generation doesn't fail the build
- `if: always()` - Screenshots are uploaded even if other steps fail

## 🚀 Running Locally

To generate screenshots on your local machine:

```bash
# Generate screenshots
./gradlew recordRoborazziDebug

# View screenshots
open app/build/outputs/roborazzi/
# Or on Linux:
xdg-open app/build/outputs/roborazzi/
```

## 📝 Adding New Screenshots

To add screenshots for new screens:

1. Ensure your composable has a `@Preview` annotation
2. Create a screenshot test in `app/src/test/java/com/yapp/android/screenshot/`
3. Run the test to generate the screenshot

Example:
```kotlin
@Test
fun captureMyScreenPreview() {
    composeTestRule.setContent {
        YappTheme {
            MyScreen()
        }
    }
    
    composeTestRule.onRoot().captureRoboImage(
        "app/src/test/screenshots/MyScreen.png"
    )
}
```

## 🎨 Screenshot Uses

These screenshots are valuable for:

- **Visual Review**: Quickly see UI changes without running the app
- **Documentation**: Maintain visual documentation of the app's UI
- **Regression Testing**: Detect unintended UI changes
- **Design Review**: Share with designers for feedback
- **Stakeholder Updates**: Show progress to non-technical team members

## 📚 Additional Resources

- [Screenshot Test README](app/src/test/java/com/yapp/android/screenshot/README.md) - Detailed technical documentation
- [Roborazzi Documentation](https://github.com/takahirom/roborazzi)
- [Compose Testing Guide](https://developer.android.com/jetpack/compose/testing)

---

**Note**: Screenshots are automatically generated on every PR. If you don't see the artifact, check the workflow logs for any errors.
