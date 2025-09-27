package com.yapp.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yapp.android.ui.navigation.Routes
import com.yapp.android.ui.screens.HomeScreen
import com.yapp.android.ui.screens.LoginScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN_SCREEN
    ) {
        composable(Routes.LOGIN_SCREEN) {
            LoginScreen(
                onLoginClick = {
                    navController.navigate(Routes.HOME_SCREEN) {
                        // Geri tuşuna basıldığında login ekranına dönmemesi için
                        popUpTo(Routes.LOGIN_SCREEN) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(Routes.HOME_SCREEN) {
            HomeScreen()
        }
    }
}