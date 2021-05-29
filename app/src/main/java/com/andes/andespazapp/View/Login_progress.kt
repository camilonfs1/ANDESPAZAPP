package com.andes.andespazapp.View

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.andes.andespazapp.DB.LocalDB
import com.andes.andespazapp.Model.Person
import com.andes.andespazapp.R
import com.andes.andespazapp.View.Student.MainStudentMenu
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class Login_progress : AppCompatActivity() {

    private lateinit var database: LocalDB

    private var mAuth: FirebaseAuth? = FirebaseAuth.getInstance()
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mUserReference: DatabaseReference? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_progress)
        val window: Window = this@Login_progress.window
        window.statusBarColor = ContextCompat.getColor(
            this@Login_progress,
            R.color.colorPrimaryDark
        )

        var email = intent.getStringExtra("email")
        readDB(email)
    }

    private fun readDB(email: String) {//This function read database firebase, search user and consult local databse if key or identify isnot register in local then download all data and regist all data in local

        System.out.println("Inicio modulo login")

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
                        if (key == email) {
                            var Id = Integer.parseInt(e.child("Id").value.toString())
                            next(Id.toString())
                        }
                    }
                } else {
                    System.out.println("--------------------------------No User" + mUser!!.uid)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })


    }
    fun next(Id: String) {
        val intent = Intent(this, MainStudentMenu::class.java)
        intent.putExtra("id", Id)
        intent.putExtra("internet", "OK")
        startActivity(intent)
    }

}