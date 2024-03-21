package com.example.safedrive.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.safedrive.components.TopBar

@Composable
fun HomeScreen(navController: NavController) {
    Surface(color = Color.White) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopBar(navController = navController, title = "")
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Main Content", style = MaterialTheme.typography.displayMedium)
            }
            BottomNavigationBar()
        }
    }
}


@Composable
fun BottomNavigationBar() {
    Surface(
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {

            Text(text = "Drive")
            Text(text = "Search")
            Text(text = "Settings")
        }
    }
}

