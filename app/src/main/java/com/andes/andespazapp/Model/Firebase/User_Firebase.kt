package com.andes.andespazapp.Model.Firebase

import android.content.Context
import com.andes.andespazapp.Model.Person
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

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
        mUserReference = mDatabaseReference!!.child("Users").child("Teachers").child(mUser!!.uid)
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

    fun UpdateLogin(email:String, pass:String):Boolean{
        if(pass == ""){

        }else{

        }
        return true
    }
}