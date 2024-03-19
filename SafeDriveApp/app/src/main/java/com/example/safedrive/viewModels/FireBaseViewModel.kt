package com.example.safedrive.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore


data class User(val email: String, val password: String, val fName: String, val lName: String)


class FireBaseViewModel : ViewModel() {
    val firestore = Firebase.firestore

    fun createUser(user: User) {
        firestore.collection("users").add(user)
            .addOnSuccessListener { u -> Log.i("***", "User Created") }
            .addOnFailureListener { e -> Log.i("***", e.toString()) }
    }
    fun loginUser(user:String, password: String){
        
    }
}