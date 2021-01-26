package com.andes.andespazapp.View

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.andes.andespazapp.DB.DB_Administrator
import com.andes.andespazapp.Model.User
import com.andes.andespazapp.R
import com.andes.andespazapp.View.CRUD.CRUD_Individual_User
import com.andes.andespazapp.View.Student.MainStudentMenu
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class Login_progress : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = FirebaseAuth.getInstance()
    var databaseHandler: DB_Administrator?=null
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mUserReference: DatabaseReference? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_progress)
        val window: Window = this@Login_progress.window
        window.statusBarColor = ContextCompat.getColor(this@Login_progress, R.color.colorPrimaryDark)
        var email = intent.getStringExtra("email")
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
                            var Id=e.child("Id").value.toString()
                            if(readdb(Id) is Boolean){
                                var Nombre=e.child("Nombre").value.toString()
                                var Roll=e.child("Roll").value.toString()
                                var Edad=e.child("Edad").value.toString()
                                var Region=e.child("Region").value.toString()
                                var Andes=e.child("Andes").value as Boolean
                                var Email=e.child("Email").value.toString()
                                var icon=Integer.parseInt(e.child("icon").value.toString())
                                var user = User(Id!!,Roll!!, Andes!!,Nombre,Id,Region,Edad,Email,icon)
                                System.out.println("--------------------------------WRITE")
                                writedb(user)
                            }else{
                                System.out.println("--------------------------------NO WRITE")
                                next(readdb(Id) as User)
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

    }
    fun readdb(id : String) : Any{
        databaseHandler = DB_Administrator(this)
        var res = databaseHandler!!.getUser(id)
        return res
    }
    fun writedb(user:User){
        databaseHandler = DB_Administrator(this)
        databaseHandler!!.insertData_user(user)
        next(user)
    }
    fun next(user:User ){
        val intent = Intent(this, MainStudentMenu::class.java)
        intent.putExtra("id", user.identify)
        startActivity(intent)
    }
}