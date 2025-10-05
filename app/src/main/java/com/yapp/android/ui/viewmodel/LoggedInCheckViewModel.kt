package com.yapp.android.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.yapp.android.data.database.AppDatabase
import com.yapp.android.data.repository.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoggedInCheckViewModel(application: Application) : AndroidViewModel(application) {
    private val database = AppDatabase.getDatabase(application)
    private val repository = LoginRepository(database.userDao())
    
    private val _navigationDestination = MutableStateFlow<NavigationDestination>(NavigationDestination.None)
    val navigationDestination: StateFlow<NavigationDestination> = _navigationDestination.asStateFlow()
    
    init {
        checkAuthenticationStatus()
    }
    
    private fun checkAuthenticationStatus() {
        viewModelScope.launch {
            repository.getLoggedInUser().collect { user ->
                val isAuthenticated = user != null && user.isLoggedIn
                _navigationDestination.value = if (isAuthenticated) {
                    NavigationDestination.Home
                } else {
                    NavigationDestination.Login
                }
            }
        }
    }
    
    fun resetNavigation() {
        _navigationDestination.value = NavigationDestination.None
    }
}

sealed class NavigationDestination {
    object None : NavigationDestination()
    object Home : NavigationDestination()
    object Login : NavigationDestination()
}
