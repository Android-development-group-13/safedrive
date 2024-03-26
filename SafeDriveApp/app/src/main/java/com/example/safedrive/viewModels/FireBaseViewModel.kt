package com.example.safedrive.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await


data class User(val email: String, val password: String, val fName: String, val lName: String)


class FireBaseViewModel : ViewModel() {
    val firestore = Firebase.firestore
    val fireAuth = Firebase.auth


    fun createUser(email: String, password: String): Boolean {
        return try {
            fireAuth.createUserWithEmailAndPassword(email, password)
            true
        } catch (e: Exception){
            false
        }
    }

     fun loginUser(email: String, password: String): Boolean {
        return try {
            fireAuth.signInWithEmailAndPassword(email, password)
            Log.i("***", "User $email is logged in!")
            true
        } catch (e: Exception) {
            Log.d("***", e.message.toString())
            false
        }
    }

    fun signOutUser() {
        fireAuth.signOut()
    }
}