package com.example.safedrive.screens

import com.example.safedrive.R
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import kotlinx.coroutines.delay


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WelcomeScreen(navController: NavController) {
    Scaffold(topBar = {}) {
        Image(
            painter = painterResource(id = R.drawable.img ), // Replace with your image resource
            contentDescription = "Splash Image",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {



            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo1 ), // Replace with your image resource
                    contentDescription = "Splash Image",
                    modifier = Modifier
                        .fillMaxSize().size(100.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = { navController.navigate("login") }) {
                    Text(text = "Get Started")
                }

            }
        }
    }
    LaunchedEffect(Unit) {
        delay(2000) // 2 seconds delay
        navController.navigate("login")
    }
}

@Preview
@Composable
fun PreviewWelcomeScreen() {
    val navController = rememberNavController()
    WelcomeScreen(navController = navController)
}
