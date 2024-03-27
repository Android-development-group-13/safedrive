package com.example.safedrive


import TopBar
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.NonNull
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.safedrive.components.BottomNavigationBar
import com.example.safedrive.components.NavRoute
import com.example.safedrive.screens.HomeScreen
import com.example.safedrive.screens.LoginScreen
import com.example.safedrive.screens.RecordDriveScreen
import com.example.safedrive.screens.SettingsScreen
import com.example.safedrive.screens.SignUpScreen
import com.example.safedrive.screens.WelcomeScreen
import com.example.safedrive.ui.theme.SafedriveTheme
import com.example.safedrive.viewModels.FireBaseViewModel
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SafedriveTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  MainScreen()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    // Collect the current route
    val currentRoute = currentRoute(navController)

    Scaffold(
        topBar = {
            if (currentRoute !in listOf(NavRoute.Login.route, NavRoute.SignUp.route, NavRoute.Welcome.route)) {
                TopBar(navController = navController, title = "")
            }
        },
        bottomBar = {
            if (currentRoute !in listOf(NavRoute.Login.route, NavRoute.SignUp.route, NavRoute.Welcome.route)) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) {
        NavigationApp(navController = navController)
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Composable
fun NavigationApp(navController: NavHostController) {

    val firebaseAuth = FirebaseAuth.getInstance()

    val authStateListener = remember {
        FirebaseAuth.AuthStateListener { auth ->
            if (auth.currentUser != null) {
                // User is signed in
                navController.navigate(NavRoute.Home.route)
            } else {
                // User is signed out
                navController.navigate(NavRoute.Login.route)
            }
        }
    }

    DisposableEffect(Unit) {
        firebaseAuth.addAuthStateListener(authStateListener)
        onDispose {
            firebaseAuth.removeAuthStateListener(authStateListener)
        }
    }

    NavHost(navController = navController, startDestination = NavRoute.Welcome.route) {
        composable(route = NavRoute.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = NavRoute.Login.route) {
            LoginScreen(navController = navController, firebaseviewmodel =  FireBaseViewModel())
        }
        composable(route = NavRoute.SignUp.route) {
            SignUpScreen(navController = navController, firebaseviewmodel =  FireBaseViewModel())
        }
        composable(route = NavRoute.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = NavRoute.RecordDrive.route) {
            RecordDriveScreen(navController = navController)
        }
        composable(route = NavRoute.Settings.route) {
            SettingsScreen(navController = navController)
        }
    }
}
