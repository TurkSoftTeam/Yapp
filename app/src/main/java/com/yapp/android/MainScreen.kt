package com.yapp.android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yapp.android.ui.theme.YappTheme

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val counter by viewModel.counter.collectAsState()
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        Text(
            text = "Welcome to Yapp!",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        Text(
            text = "Counter: $counter",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        Button(onClick = { viewModel.incrementCounter() }) {
            Text("Increment Counter")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    YappTheme {
        MainScreen(viewModel = MainViewModel())
    }
}