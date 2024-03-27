package com.example.safedrive.components

sealed class NavRoute(val route: String) {
    data object Welcome : NavRoute("welcome")
    data object Login : NavRoute("login")
    data object SignUp : NavRoute("signup")
    data object Home : NavRoute("home")
    data object RecordDrive : NavRoute("record_drive")
    data object Settings : NavRoute("settings")
}