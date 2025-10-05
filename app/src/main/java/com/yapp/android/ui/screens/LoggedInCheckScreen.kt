package com.yapp.android.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yapp.android.ui.viewmodel.LoginViewModel

@Composable
fun LoggedInCheckScreen(
    onNavigateToHome: () -> Unit,
    onNavigateToLogin: () -> Unit,
    viewModel: LoginViewModel = viewModel()
) {
    val isAuthenticated by viewModel.isAuthenticated.collectAsState()
    
    LaunchedEffect(isAuthenticated) {
        if (isAuthenticated) {
            onNavigateToHome()
        } else {
            onNavigateToLogin()
        }
    }
}
