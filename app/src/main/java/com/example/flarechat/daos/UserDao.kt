package com.example.flarechat.daos

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserDao {

    private val db=FirebaseFirestore.getInstance()
    private val usersCollection=db.collection("users")

    fun addUser(user: com.example.flarechat.models.User?){
        user?.let {
            GlobalScope.launch(Dispatchers.IO ){
            usersCollection.document(user.uid).set(it)
        }
    }
    }

    fun getUserById(uId: String): Task<DocumentSnapshot>{
        return usersCollection.document(uId).get()
    }

}