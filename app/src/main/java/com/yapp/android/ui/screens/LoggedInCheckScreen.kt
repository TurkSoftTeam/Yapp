package com.yapp.android.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yapp.android.ui.viewmodel.LoggedInCheckViewModel
import com.yapp.android.ui.viewmodel.NavigationDestination

@Composable
fun LoggedInCheckScreen(
    onNavigateToHome: () -> Unit,
    onNavigateToLogin: () -> Unit,
    viewModel: LoggedInCheckViewModel = viewModel()
) {
    val navigationDestination by viewModel.navigationDestination.collectAsState()
    
    LaunchedEffect(navigationDestination) {
        when (navigationDestination) {
            is NavigationDestination.Home -> {
                onNavigateToHome()
                viewModel.resetNavigation()
            }
            is NavigationDestination.Login -> {
                onNavigateToLogin()
                viewModel.resetNavigation()
            }
            NavigationDestination.None -> {
                // Do nothing, still checking
            }
        }
    }
}
