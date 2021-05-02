package com.andes.andespazapp.Model.Firebase

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import com.andes.andespazapp.Model.Person
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class User_Firebase {
    lateinit var user : Person
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mUserReference: DatabaseReference? = null
    private var mAuth: FirebaseAuth? = null

    fun readDB(id : String): Person    {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference
        mAuth = FirebaseAuth.getInstance()
        val mUser = mAuth!!.currentUser
        mUserReference = mDatabaseReference!!.child("Usuarios").child(mUser!!.uid)
        mUserReference?.addValueEventListener(object : ValueEventListener  {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var name = snapshot.child("Name").value as String
                    var Roll = snapshot.child("Roll").value as String
                } else {
                    System.out.println("--------------------------------No User")
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
        return user
    }

    fun UpdateDB(user:Person, context: Context){

    }

    fun UpdateLogin(user: Any){
        val emailAddress = "camilonfs1@gmail.com"
        Log.d(TAG, "------")
        Firebase.auth.sendPasswordResetEmail(emailAddress)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "Email sent.")
                }
            }
    }


}