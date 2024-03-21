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
            .height(56.dp)
    ) {

        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            if (navController != null) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = "Back"
                        )
                    }
                )
            } else {
                Spacer(modifier = Modifier.width(60.dp))
                // TODO add logo picture and move icons to the right of the scree
                Image(
                    painter = painterResource(id = R.drawable.logo1 ), // Replace with your image resource
                    contentDescription = "Splash Image",
                    modifier = Modifier
                        .fillMaxSize().size(100.dp),
                    contentScale = ContentScale.Fit
                )

            }

            Text(
                text = title,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(48.dp))
        }
    }
}