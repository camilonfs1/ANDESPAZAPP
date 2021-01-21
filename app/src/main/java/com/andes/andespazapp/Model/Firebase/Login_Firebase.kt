package com.andes.andespazapp.Model.Firebase

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.andes.andespazapp.Model.User
import com.andes.andespazapp.View.Student.MainStudentMenu
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class Login_Firebase {
    private var mAuth: FirebaseAuth? = FirebaseAuth.getInstance()

    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mUserReference: DatabaseReference? = null

    fun login(context: Context, Email :String, Pass: String) {
        mAuth?.signInWithEmailAndPassword(Email,Pass)!!
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    updateUI(context, Email)
                } else {
                    Toast.makeText(
                        context,
                        "Tenemos un error, comprueba tus datos y conexion :(",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
    private fun updateUI(context: Context, email:String) {
       // var intent = Intent(context, MainStudentMenu::class.java)
        //intent.putExtra("mUser", "")
      //  context.startActivity(intent)
        readDB(email)
    }
    private fun readDB(email:String){//This function read database firebase, search user and consult local databse if key or identify isnot register in local then download all data and regist all data in local

        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference
        mAuth = FirebaseAuth.getInstance()
        val mUser = mAuth!!.currentUser
        mUserReference = mDatabaseReference!!.child("Usuarios")
        mUserReference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (e in snapshot.children) {
                        var key = e.child("Email").value
                        if(key==email){
                            var local = 1
                            if(local==1){
                                var Nombre=e.child("Nombre").value.toString()
                                var Roll=e.child("Roll").value.toString()
                                var Edad=e.child("Edad").value.toString()
                                var Region=e.child("Region").value.toString()
                                var Andes=e.child("Andes").value as Boolean
                                var Email=e.child("Email").value.toString()
                                var icon=Integer.parseInt(e.child("icon").value.toString())
                                var Id=e.child("Id").value.toString()

                                System.out.println("--------------------------------User : "+key)
                                var user = User(
                                    Id!!,
                                    Roll!!,
                                    Andes!!,
                                    Nombre,
                                    Id,
                                    Region,
                                    Edad,
                                    Email,
                                    icon
                                )
                            }

                        }

                    }
                } else {
                    System.out.println("--------------------------------No User"+mUser!!.uid)

                }
            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
        //return user
    }

}