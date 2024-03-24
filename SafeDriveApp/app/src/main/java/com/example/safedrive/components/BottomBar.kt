package com.example.safedrive.components

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.safedrive.R


@Composable
fun BottomNavigationBar() {
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
                onClick = { },
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_drive_eta_24),
                        contentDescription = "Drive",
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
            )
            IconButton(
                onClick = { },
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_home_filled_24),
                        contentDescription = "Home",
                        modifier = Modifier
                            .size(40.dp)

                    )
                }
            )
            IconButton(
                onClick = { },
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_settings_24),
                        contentDescription = "Settings",
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
            )

        }
    }
}