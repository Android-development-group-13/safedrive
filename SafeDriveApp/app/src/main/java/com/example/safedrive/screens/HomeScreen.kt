package com.example.safedrive.screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.safedrive.R
import com.example.safedrive.components.BottomNavigationBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {

        Image(
            painter = painterResource(id = R.drawable.main_background ), // Replace with your image resource
            contentDescription = "Splash Image",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.padding(55.dp))
                Text(text = "You travelled with us", style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)

                )
                Text(text = "72 h 32 min", style = MaterialTheme.typography.bodySmall,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    ImageWithButton(navController)
                }

            }
    }

@Composable
fun ImageWithButton(navController: NavController) {
    Box(
        modifier = Modifier
            .size(width = 250.dp, height = 250.dp)
            .clickable {
                // TODO Navigate to another screen when the Box is clicked
                navController.navigate("login")
            },
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.start_driving__btn),
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(alpha = 0.8f), // Adjust the alpha value as needed
            contentScale = ContentScale.Crop
        )
        Text(
            text = "START DRIVING",
            color = Color.White,
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun StartDrivingButton() {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState()

    Box(
        modifier = Modifier
            .size(width = 250.dp, height = 250.dp)
            .clip(CircleShape)
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(bounded = true)
            ) {
                // Clicked
            },
        contentAlignment = Alignment.Center

    ) {
        Text(text = "START DRIVING", style = MaterialTheme.typography.displaySmall,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}


