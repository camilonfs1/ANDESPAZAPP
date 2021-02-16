package com.andes.andespazapp.Model.Firebase

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.andes.andespazapp.Model.Person
import com.andes.andespazapp.View.Login_progress
import com.andes.andespazapp.View.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class Login_Firebase {
    private var mAuth: FirebaseAuth? = FirebaseAuth.getInstance()

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
                    returne(context, Email)
                }
            }
    }
    private fun updateUI(context: Context, email:String) {
       var intent = Intent(context, Login_progress::class.java)
      intent.putExtra("email", email)
      context.startActivity(intent)

    }
    private fun returne(context: Context, email:String) {
        var intent = Intent(context, MainActivity::class.java)
        intent.putExtra("email", email)
        context.startActivity(intent)

    }





}