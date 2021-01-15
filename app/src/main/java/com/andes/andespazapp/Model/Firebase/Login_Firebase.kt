package com.andes.andespazapp.Model.Firebase

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.andes.andespazapp.View.Student.MainStudentMenu
import com.google.firebase.auth.FirebaseAuth

class Login_Firebase {
    private var mAuth: FirebaseAuth? = FirebaseAuth.getInstance()

    fun login(context: Context, Email :String, Pass: String) {
        mAuth?.signInWithEmailAndPassword(Email,Pass)!!
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    updateUI(context)
                } else {
                    Toast.makeText(
                        context,
                        "Tenemos un error, comprueba tus datos y conexion :(",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
    private fun updateUI(context: Context) {
        val mUser = mAuth!!.currentUser
        var intent = Intent(context, MainStudentMenu::class.java)
        intent.putExtra("mUser", mUser)
        context.startActivity(intent)
    }

}