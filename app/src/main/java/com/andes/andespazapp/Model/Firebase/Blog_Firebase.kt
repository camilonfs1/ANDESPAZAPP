package com.andes.andespazapp.Model.Firebase

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.andes.andespazapp.DB.DB_Administrator
import com.andes.andespazapp.Model.Blog_item
import com.andes.andespazapp.Model.Commentary
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.sql.DriverManager

class Blog_Firebase {
    private var FireData: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null
    private var mDatabase1: DatabaseReference? = null

    var items: ArrayList<Blog_item>? = ArrayList()
    var commen: ArrayList<Commentary>? = ArrayList()
    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseReference: DatabaseReference? = null

    fun ReadDB(): ArrayList<Blog_item>{

        items!!.add(Blog_item("1", "camilo vargas0",   "Discusión numero uno, propuesta para el desarrollo del tema propuesta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("2", "camilo vargas1",   "DEBATE ANDES segunda", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("3", "camilo vargas2",   "DEBATE ANDES tercera", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("4", "camilo vargas3",   "DEBATE ANDES cuarta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("5", "camilo vargas4",   "DEBATE ANDES quinta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("6", "camilo vargas5",   "Discusión numero uno, propuesta para el desarrollo del tema propuesta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("7", "camilo vargas6",   "DEBATE ANDES segunda", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("8", "camilo vargas7",   "DEBATE ANDES tercera", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("9", "camilo vargas8",   "DEBATE ANDES cuarta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("10", "camilo vargas9",   "DEBATE ANDES quinta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("11", "camilo vargas10",   "Discusión numero uno, propuesta para el desarrollo del tema propuesta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("12", "camilo vargas11",   "DEBATE ANDES segunda", 1, 10, 1,"#fffff"))
        items!!.add(Blog_item("13", "camilo vargas12",   "DEBATE ANDES tercera", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("14", "camilo vargas13",   "DEBATE ANDES cuarta", 6, 1, 1,"#fffff"))
        items!!.add(Blog_item("15", "camilo vargas14",   "DEBATE ANDES quinta", 1, 1, 1,"#fffff"))

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

    fun getBlogDetail(): ArrayList<Commentary>{
        commen= ArrayList()
        commen!!.add(Commentary("1","camilo","comentario 1","2","1"))
        commen!!.add(Commentary("1","sergio","comentario 1","3","1"))
        commen!!.add(Commentary("1","loany","comentario 1","1","1"))
        commen!!.add(Commentary("1","mario","comentario 1","1","1"))
        commen!!.add(Commentary("1","junito","comentario 1","1","1"))
        commen!!.add(Commentary("1","maria","comentario 1","1","1"))
        commen!!.add(Commentary("1","marianita","comentario que no debe salir","1","2"))

        return commen!!
    }
}