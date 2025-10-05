package com.yapp.android.data.repository

import com.yapp.android.data.database.User
import com.yapp.android.data.database.UserDao
import kotlinx.coroutines.flow.Flow

class UserInteractionRepository(private val userDao: UserDao) {
    
    fun getLoggedInUser(): Flow<User?> = userDao.getLoggedInUser()
    
    suspend fun login(username: String, password: String): Boolean {
        // Check credentials (hardcoded as per requirement)
        if (username == "gurkan" && password == "1234") {
            // Logout all users first
            userDao.logoutAllUsers()
            
            // Check if user exists in database
            val existingUser = userDao.getUserByUsername(username)
            if (existingUser == null) {
                // Insert new user
                userDao.insertUser(
                    User(
                        username = username,
                        isLoggedIn = true,
                        loginTimestamp = System.currentTimeMillis()
                    )
                )
            } else {
                // Update existing user to logged in
                userDao.loginUser(username)
            }
            return true
        }
        return false
    }
    
    suspend fun logout() {
        userDao.logoutAllUsers()
    }
}
