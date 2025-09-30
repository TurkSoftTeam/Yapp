package com.yapp.android.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val username: String,
    val isLoggedIn: Boolean = false,
    val loginTimestamp: Long = System.currentTimeMillis()
)
