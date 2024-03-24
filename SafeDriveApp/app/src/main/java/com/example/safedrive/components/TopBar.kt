package com.example.safedrive.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.safedrive.R

// TODO move Top bar to components folder


@Composable
fun TopBar(navController: NavController?, title: String) {
    Surface(
        color = MaterialTheme.colorScheme.secondary,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (navController != null) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = "Back",
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                )
            } else {
                // Logo
                Image(
                    painter = painterResource(id = R.drawable.logo_white),
                    contentDescription = "Splash Image",
                    modifier = Modifier
                        .size(40.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Text(
                text = title,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f)
            )

            // Inbox icon
            IconButton(
                onClick = { /* Handle inbox icon click */ },
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.inbox_small),
                        contentDescription = "Inbox",
                        modifier = Modifier.size(35.dp)
                    )
                }
            )

            // User icon
            IconButton(
                onClick = { /* Handle user icon click */ },
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.user_icon_small),
                        contentDescription = "User",
                        modifier = Modifier.size(40.dp)
                    )
                }
            )
        }
    }
}