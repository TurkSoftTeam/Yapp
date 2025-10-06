package com.yapp.android.screenshot

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import com.github.takahirom.roborazzi.captureRoboImage
import com.yapp.android.MainScreen
import com.yapp.android.MainViewModel
import com.yapp.android.ui.theme.YappTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(sdk = [33])
class MainScreenScreenshotTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun captureMainScreenPreview() {
        composeTestRule.setContent {
            YappTheme {
                MainScreen(viewModel = MainViewModel())
            }
        }

        composeTestRule.onRoot().captureRoboImage()
    }
}
