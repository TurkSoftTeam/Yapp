package com.yapp.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yapp.android.ui.navigation.Routes
import com.yapp.android.ui.screens.HomeScreen
import com.yapp.android.ui.screens.LoginScreen
import com.yapp.android.ui.viewmodel.LoginViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val loginViewModel: LoginViewModel = viewModel()
    val isAuthenticated by loginViewModel.isAuthenticated.collectAsState()
    
    // Determine start destination based on authentication status from ViewModel
    val startDestination = if (isAuthenticated) {
        Routes.HOME_SCREEN
    } else {
        Routes.LOGIN_SCREEN
    }
    
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
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