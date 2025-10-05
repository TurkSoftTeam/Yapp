package com.yapp.android.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.yapp.android.data.database.AppDatabase
import com.yapp.android.data.repository.UserInteractionRepository
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val database = AppDatabase.getDatabase(application)
    private val repository = UserInteractionRepository(database.userDao())
    
    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }
}
