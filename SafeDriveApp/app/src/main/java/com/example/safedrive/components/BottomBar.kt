package com.example.safedrive.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.safedrive.R


@Composable
fun BottomNavigationBar(navController: NavController) {
    Surface(
        color = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            IconButton(
                onClick = { navController.navigate("record_drive")  },
                content = {
                    Image(
                        painter = painterResource(R.drawable.baseline_drive_eta_24),
                        contentDescription = "drive",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
            )
            IconButton(
                onClick = {navController.navigate("home") },
                content = {
                    Image(
                        painter = painterResource(R.drawable.baseline_home_filled_24),
                        contentDescription = "home",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
            )
            IconButton(
                onClick = { navController.navigate("settings")},
                content = {
                    Image(
                        painter = painterResource(R.drawable.baseline_settings_24),
                        contentDescription = "settings",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
            )

        }
    }
}