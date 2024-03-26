package com.example.safedrive.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.safedrive.R
import com.example.safedrive.ui.theme.Shapes
import com.example.safedrive.viewModels.FireBaseViewModel



@Composable
fun LoginScreen(navController: NavController, firebaseviewmodel: FireBaseViewModel) {
    var email: String  by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "Login Failed") },
            text = { Text(text = errorMessage) },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("OK")
                }
            }
        )
    }
    Scaffold(topBar = {}) {
        Column(
            Modifier
                .padding(it)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.height(365.dp)) {
                Image(
                    painterResource(id = R.drawable.log_in_background),
                    contentDescription = "Splash Image",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painterResource(id = R.drawable.logo_white_big),
                        contentDescription = "Logo Image",
                        modifier = Modifier
                            .height(202.dp)
                            .width(470.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Image(
                        painterResource(id = R.drawable.user_icon_big),
                        contentDescription = "User Icon",
                        modifier = Modifier
                            .height(150.dp)
                            .width(150.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = { Text(text = "Email") },
                value = email,
                onValueChange = {email = it})
            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                label = { Text(text = "Paswword") },
                value = password,
                onValueChange = { password = it})
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Forgot Your Password ?",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
            Button(shape = Shapes.medium,onClick = {
                if(firebaseviewmodel.loginUser(email, password)){
                    navController.navigate("home")
                }
                else{
                    errorMessage = "Your credentials are incorrect. Please try again."
                    showDialog = true
                }

            }
            ) {
                Text(text = "Login")
            }
            Button(colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onSurface), shape = Shapes.medium,onClick = {
                    navController.navigate("signup")

            }
            ) {
                Text(text = "Sign Up")
            }
        }
    }


}