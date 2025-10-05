package com.yapp.android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yapp.android.ui.theme.YappTheme
import com.yapp.android.R
import com.yapp.android.ui.viewmodel.HomeViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onLogout: () -> Unit = {},
    viewModel: HomeViewModel = viewModel()
) {
    val chapters = listOf("Chapter 1", "Chapter 2", "Chapter 3")
    val lessons = listOf(
        "Start your onboarding",
        "Turn down the stress volume",
        "Daily Calm",
        "Spiritual 1",
        "The Cure for Boredom"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("") },
                actions = {
                    IconButton(onClick = {
                        viewModel.logout()
                        onLogout()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "Logout"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            TopBar()
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow {
                items(chapters) { chapter ->
                    ChapterTab(chapter)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            lessons.forEach { lesson ->
                LessonItem(lesson)
                Spacer(modifier = Modifier.height(8.dp))
            }
            BottomNavigationBar()
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.devices_24dp_1f1f1f),
            contentDescription = "Header Image"
        )
        IconButton(onClick = { /* Handle search */ }) {
            Icon(
                painter = painterResource(id = R.drawable.search_24dp_1f1f1f),
                contentDescription = "Search Icon"
            )
        }
    }
}

@Composable
fun ChapterTab(chapter: String) {
    Text(
        text = chapter,
        color = MaterialTheme.colorScheme.primary,
        fontSize = 16.sp,
        modifier = Modifier.padding(horizontal = 8.dp)
    )
}

@Composable
fun LessonItem(lesson: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = lesson)
        IconButton(onClick = { /* Handle play action */ }) {
            Icon(
                painter = painterResource(id = R.drawable.play_arrow_24dp_1f1f1f),
                contentDescription = "Play Icon"
            )
        }
    }
}

@Composable
fun BottomNavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        NavigationItem("Today")
        NavigationItem("Routine")
        NavigationItem("Track")
        NavigationItem("Calendar")
        NavigationItem("Profile")
    }
}

@Composable
fun NavigationItem(label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(id = R.drawable.navigation_24dp_1f1f1f),
            contentDescription = "$label Icon"
        )
        Text(text = label, fontSize = 12.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun MeditationLessonsScreenPreview() {
    YappTheme {
        HomeScreen()
    }
}