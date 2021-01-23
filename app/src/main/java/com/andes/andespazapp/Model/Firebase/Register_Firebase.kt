package com.andes.andespazapp.Model.Firebase

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.andes.andespazapp.DB.DB_Administrator
import com.andes.andespazapp.Model.User
import com.andes.andespazapp.View.MainActivity
import com.andes.andespazapp.View.MainRegisterActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register_Firebase {
    private var mDatabase: DatabaseReference? = null
    private var mMessageReference: DatabaseReference? = null
    private var mAuth: FirebaseAuth? = FirebaseAuth.getInstance()
    //local
    var databaseHandler: DB_Administrator?=null

    fun RegisterUser(user: User,context: Context,Pass:String){
        mDatabase = FirebaseDatabase.getInstance().reference
        mMessageReference = FirebaseDatabase.getInstance().getReference("message")
        val mUser = mAuth!!.currentUser
        mDatabase = mDatabase!!.child("Usuarios").child(user.identify!!)

        mAuth!!.createUserWithEmailAndPassword(user.email!!, Pass!!)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    mDatabase!!.child("Nombre").setValue(user.name!!)
                    mDatabase!!.child("Roll").setValue(user.roll!!)
                    mDatabase!!.child("Edad").setValue(user.age!!)
                    mDatabase!!.child("Region").setValue(user.region!!)
                    mDatabase!!.child("Andes").setValue(user.andes_asociate!!)
                    mDatabase!!.child("Email").setValue(user.email!!)
                    mDatabase!!.child("icon").setValue(user.icon!!)
                    mDatabase!!.child("Id").setValue(user.identify!!)
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
    fun reg_local(context: Context, user:User){
        databaseHandler = DB_Administrator(context)
        if(databaseHandler!!.insertData_user(user!!)==user){
            System.out.println("Usuario cargado en base de datos local")
        }
    }
    private fun regNew(context: Context) {
        var intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }
}