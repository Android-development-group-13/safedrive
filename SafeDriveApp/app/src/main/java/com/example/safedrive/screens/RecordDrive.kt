package com.example.safedrive.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.navigation.NavController
import com.example.safedrive.R
import com.example.safedrive.components.BottomNavigationBar
import com.example.safedrive.components.TopBar

@Composable
fun RecordDriveScreen(navController: NavController) {
    Scaffold(topBar = { TopBar(navController = navController, title = "") }){
        Image(
            painter = painterResource(id = R.drawable.main_background ), // Replace with your image resource
            contentDescription = "Splash Image",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            Modifier
                .padding(it)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            BottomNavigationBar(navController)
        }
    }



}