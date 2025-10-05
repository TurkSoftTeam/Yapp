package com.yapp.android.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yapp.android.ui.navigation.Routes
import com.yapp.android.ui.screens.HomeScreen
import com.yapp.android.ui.screens.LoggedInCheckScreen
import com.yapp.android.ui.screens.LoginScreen
import com.yapp.android.ui.viewmodel.LoginViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val loginViewModel: LoginViewModel = viewModel()
    
    NavHost(
        navController = navController,
        startDestination = Routes.LOGGED_IN_CHECK_SCREEN
    ) {
        composable(Routes.LOGGED_IN_CHECK_SCREEN) {
            LoggedInCheckScreen(
                onNavigateToHome = {
                    navController.navigate(Routes.HOME_SCREEN) {
                        popUpTo(Routes.LOGGED_IN_CHECK_SCREEN) {
                            inclusive = true
                        }
                    }
                },
                onNavigateToLogin = {
                    navController.navigate(Routes.LOGIN_SCREEN) {
                        popUpTo(Routes.LOGGED_IN_CHECK_SCREEN) {
                            inclusive = true
                        }
                    }
                },
                viewModel = loginViewModel
            )
        }
        composable(Routes.LOGIN_SCREEN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.HOME_SCREEN) {
                        // Prevent going back to login screen on back press
                        popUpTo(Routes.LOGIN_SCREEN) {
                            inclusive = true
                        }
                    }
                },
                viewModel = loginViewModel
            )
        }
        composable(Routes.HOME_SCREEN) {
            HomeScreen()
        }
    }
}