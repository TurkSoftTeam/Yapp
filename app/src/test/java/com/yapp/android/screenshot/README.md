# Compose Screenshot Tests

This directory contains screenshot tests for Jetpack Compose screens using Roborazzi.

## Overview

Screenshot tests automatically capture images of our composable screens to verify UI appearance and catch visual regressions.

**Note**: Screenshot tests are excluded from regular test runs (`./gradlew test`) to avoid build failures. They are only executed via dedicated Roborazzi tasks.

## Running Tests

### Generate Screenshots Locally
```bash
./gradlew recordRoborazziDebug
```

### Verify Screenshots
```bash
./gradlew verifyRoborazziDebug
```

### Compare Changes
```bash
./gradlew compareRoborazziDebug
```

## CI/CD Integration

Screenshots are automatically generated during GitHub Actions builds and uploaded as artifacts:

1. After each PR build, navigate to the "Actions" tab in GitHub
2. Click on the workflow run for your PR
3. Scroll down to "Artifacts"
4. Download "composable-screenshots" to view the generated screenshots

## Screenshots Location

- Generated screenshots: `app/build/outputs/roborazzi/`
- Baseline screenshots (committed): `app/src/test/screenshots/`

## Current Screen Coverage

- ✅ HomeScreen
- ✅ LoginScreen
- ✅ MainScreen

## Adding New Screenshot Tests

1. Create a new test file in `app/src/test/java/com/yapp/android/screenshot/`
2. Use `@Preview` annotation on your composable
3. Create a test that captures the screen using `captureRoboImage()`
4. Run `recordRoborazziDebug` to generate the baseline screenshot

## Learn More

- [Roborazzi Documentation](https://github.com/takahirom/roborazzi)
- [Jetpack Compose Testing](https://developer.android.com/jetpack/compose/testing)
