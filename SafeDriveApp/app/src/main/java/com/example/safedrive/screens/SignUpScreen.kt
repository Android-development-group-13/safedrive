package com.example.safedrive.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.safedrive.R
import com.example.safedrive.components.CustomTextField
import com.example.safedrive.ui.theme.Shapes
import com.example.safedrive.viewModels.FireBaseViewModel

@Composable
fun SignUpScreen(navController: NavController, firebaseviewmodel: FireBaseViewModel) {
    var email: String  by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }
    var passwordConfirmation: String by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "Sing In Failed") },
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
            Box(modifier = Modifier.height(110.dp)) {
                Image(
                    painterResource(id = R.drawable.sign_up_background),
                    contentDescription = "Splash Image",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }
            Column(
                Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "SIGN IN", fontWeight = FontWeight.Bold, fontSize = 40.sp)
                Spacer(modifier = Modifier.height(34.dp))
                Text(text = "First Name", fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp),
                    shape = Shapes.medium,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    value = "",
                    onValueChange = { it }
                )

                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Last Name", fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp),
                    shape = Shapes.medium,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    value = "",
                    onValueChange = { it })

                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Email*", fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp),
                    shape = Shapes.medium,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    value = email,
                    onValueChange = { email = it })

                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Phone Number", fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp),
                    shape = Shapes.medium,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    value = "",
                    onValueChange = { it })

                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Password*", fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp),
                    shape = Shapes.medium,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    value = password,
                    onValueChange = { password = it })

                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Password Confirmation*", fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp),
                    shape = Shapes.medium,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    value = passwordConfirmation,
                    onValueChange = { passwordConfirmation = it })
                Button(onClick = {
                    if(password == passwordConfirmation){
                        if(firebaseviewmodel.createUser(email,password)){
                            navController.navigate("home")
                        }
                        else{
                            errorMessage = "There was a problem with your Sign-Up"
                            showDialog = true
                        }
                    }else{
                        errorMessage = "Your password is not matching your password confirmation"
                        showDialog = true
                    }
                },) {
                    Text(text = "Sing Up")
                }
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
                    Divider(modifier = Modifier.width(105.dp),thickness = 1.dp, color = MaterialTheme.colorScheme.onSurface)
                    Text(text = "Or Log In",modifier = Modifier.padding(horizontal = 5.dp))
                    Divider(modifier = Modifier.width(105.dp),thickness = 1.dp, color = MaterialTheme.colorScheme.onSurface)
                }
                Button(onClick = {navController.navigateUp()}) {
                    Text(text = "Log In")
                    
                }
                
            }
        }

    }
}