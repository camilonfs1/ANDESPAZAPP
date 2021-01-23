package com.andes.andespazapp.Model.Firebase

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.andes.andespazapp.DB.DB_Administrator
import com.andes.andespazapp.Model.Blog_item
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.sql.DriverManager

class Blog_Firebase {
    private var FireData: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null
    private var mDatabase1: DatabaseReference? = null

    var items: ArrayList<Blog_item>? = ArrayList()
    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseReference: DatabaseReference? = null

    fun ReadDB(): ArrayList<Blog_item>{

        items!!.add(Blog_item("1", "camilo vargas",   "Discusión numero uno, propuesta para el desarrollo del tema propuesta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES segunda", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES tercera", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES cuarta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES quinta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "Discusión numero uno, propuesta para el desarrollo del tema propuesta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES segunda", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES tercera", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES cuarta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES quinta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "Discusión numero uno, propuesta para el desarrollo del tema propuesta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES segunda", 1, 10, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES tercera", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES cuarta", 6, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES quinta", 1, 1, 1,"#fffff"))

        return items!!
    }
    fun createCourse(course: String, techaer: String, context: Context) {
        FireData = FirebaseDatabase.getInstance()
        mAuth = FirebaseAuth.getInstance()
        mDatabase1 = FireData!!.reference.child("Courses")//Create child Courses in firebase database
        if (!course.isEmpty()) {
            //update user profile information
            val currentCoursDb = mDatabase1!!.child(course)
            currentCoursDb.child("Name").setValue(course)
            currentCoursDb.child("Teacher").setValue(techaer)
            DriverManager.println("creado el curso")
            Toast.makeText(context, "Curso creado", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Llena la casilla nombre", Toast.LENGTH_SHORT).show()
        }
    }

    fun getBlogData(): LiveData<ArrayList<Blog_item>> {
        mDatabase = FirebaseDatabase.getInstance()
        val mutableData = MutableLiveData<ArrayList<Blog_item>>()
        mDatabaseReference = mDatabase!!.reference!!.child("Blog")//Create child Courses in firebase database
        mDatabaseReference!!.addValueEventListener(object : ValueEventListener {
            //call "Courses" child in database firebase
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()) {
                    for (e in p0.children) {
                        var cours = Blog_item("","","",1,1,1,"")

                        items!!.add(cours)
                    }
                    mutableData.value = items
                }
            }
        })
        return mutableData
    }
}