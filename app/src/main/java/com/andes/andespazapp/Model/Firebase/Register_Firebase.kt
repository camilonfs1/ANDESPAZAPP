package com.andes.andespazapp.Model.Firebase

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.andes.andespazapp.Model.User
import com.andes.andespazapp.View.MainRegisterActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register_Firebase {
    private var mDatabase: DatabaseReference? = null
    private var mMessageReference: DatabaseReference? = null
    private var mAuth: FirebaseAuth? = FirebaseAuth.getInstance()


    fun RegisterUser(user: User,context: Context,Pass:String){
        mDatabase = FirebaseDatabase.getInstance().reference
        mMessageReference = FirebaseDatabase.getInstance().getReference("message")
        if(user.roll=="Instructor"){
            mDatabase = mDatabase!!.child("Docente").child(user.key!!)
        }else if(user.roll=="Estudiante"){
            mDatabase = mDatabase!!.child("Estudiante").child(user.key!!)
        }

        mAuth!!.createUserWithEmailAndPassword(user.email!!, Pass!!)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    mDatabase!!.child("Nombre").setValue(user.name!!)
                    mDatabase!!.child("Edad").setValue(user.age!!)
                    mDatabase!!.child("Region").setValue(user.region!!)
                    if(user.roll=="Estudiante"){
                        mDatabase!!.child("Curso").setValue(user.course!!)
                    }
                    mDatabase!!.child("Andes").setValue(user.andes_asociate!!)
                    mDatabase!!.child("Email").setValue(user.email!!)
                    mDatabase!!.child("icon").setValue(user.icon!!)
                    mDatabase!!.child("Id").setValue(user.key!!)
                    Toast.makeText(context,"Usuario registrado!!",Toast.LENGTH_LONG).show()
                    regNew(context)
                }else{
                    Toast.makeText(
                        context, "Error en la autenticacion, verifica tus datos",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }
    private fun regNew(context: Context) {
        var intent = Intent(context, MainRegisterActivity::class.java)
        context.startActivity(intent)
    }
}