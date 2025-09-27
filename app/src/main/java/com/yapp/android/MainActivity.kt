package com.yapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.yapp.android.navigation.AppNavigation
import com.yapp.android.ui.theme.YappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YappTheme {
                AppNavigation()
            }
        }
    }
}