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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.safedrive.R
import com.example.safedrive.components.BottomNavigationBar
import com.example.safedrive.components.TopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = { TopBar(navController = navController, title = "") }) {
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

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {

                    StartDrivingButton()
                }
                BottomNavigationBar()
            }
    }
}
@Composable
fun StartDrivingButton() {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState()
    val cornerRadius by animateDpAsState(targetValue = if (isPressed.value) 10.dp else 50.dp)

    Box(
        modifier = Modifier
            .size(width = 250.dp, height = 250.dp)
            .background(color = Color.Black, shape = CircleShape)
            .clip(CircleShape)
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple()
            ) {
                // Clicked
            },
        contentAlignment = Alignment.Center

    ) {
        Text(text = "START DRIVING", style = MaterialTheme.typography.displaySmall, color = Color.White)
    }
}


