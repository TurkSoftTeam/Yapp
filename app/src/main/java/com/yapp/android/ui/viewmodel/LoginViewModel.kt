package com.yapp.android.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.yapp.android.data.database.AppDatabase
import com.yapp.android.data.database.User
import com.yapp.android.data.repository.UserInteractionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val database = AppDatabase.getDatabase(application)
    private val repository = UserInteractionRepository(database.userDao())
    
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()
    
    val loggedInUser = repository.getLoggedInUser()
    
    // Computed authentication state - keeps business logic in ViewModel layer
    val isAuthenticated: StateFlow<Boolean> = loggedInUser.map { user ->
        user != null && user.isLoggedIn
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )
    
    fun login(username: String, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
                val success = repository.login(username, password)
                _loginState.value = if (success) {
                    LoginState.Success
                } else {
                    LoginState.Error("Invalid username or password")
                }
            } catch (e: Exception) {
                _loginState.value = LoginState.Error(e.message ?: "Unknown error occurred")
            }
        }
    }
    
    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }
    
    fun resetLoginState() {
        _loginState.value = LoginState.Idle
    }
}

sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    object Success : LoginState()
    data class Error(val message: String) : LoginState()
}
