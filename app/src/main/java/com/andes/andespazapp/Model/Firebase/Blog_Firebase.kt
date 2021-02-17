package com.andes.andespazapp.Model.Firebase

import android.content.Context
import com.andes.andespazapp.DB.LocalDB
import com.andes.andespazapp.Model.BlogItem
import com.andes.andespazapp.Model.Commentary
import com.andes.andespazapp.Model.Person
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Blog_Firebase {

    // private lateinit var database: LocalDB
    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseReference: DatabaseReference? = null

    var context: Context? = null
    var items: ArrayList<BlogItem>? = ArrayList()
    var commen = ArrayList<Commentary>()

    fun new_blogItem(blogItem: BlogItem) {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("Blog").child(blogItem.key.toString())
        mDatabaseReference!!.child("key").setValue(blogItem.key.toString())
        mDatabaseReference!!.child("name_owner").setValue(blogItem.name_owner.toString())
        mDatabaseReference!!.child("tittle").setValue(blogItem.title.toString())
        mDatabaseReference!!.child("date").setValue(blogItem.date.toString())
        mDatabaseReference!!.child("num_commentari").setValue(blogItem.num_commentari.toString())
        mDatabaseReference!!.child("avatar_owner").setValue(blogItem.avatar_owner.toString())
        mDatabaseReference!!.child("color").setValue(blogItem.color.toString())

    }
    fun new_commentary(commentary: Commentary) {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("Blog").child(commentary.mother_key.toString()).child("Commentary")
        mDatabaseReference!!.child("key").setValue(commentary.key.toString())
        mDatabaseReference!!.child("mother_key").setValue(commentary.mother_key.toString())
        mDatabaseReference!!.child("commentary").setValue(commentary.commentary)
        mDatabaseReference!!.child("date").setValue(commentary.date.toString())
        mDatabaseReference!!.child("owner").setValue(commentary.owner)

    }


    fun getBlogDetail(): ArrayList<Commentary> {

        commen = ArrayList()
       /* commen!!.add(Commentary("1", "camilo", "comentario 1", "2", "1"))
        commen!!.add(Commentary("1", "sergio", "comentario 1", "3", "1"))
        commen!!.add(Commentary("1", "loany", "comentario 1", "1", "1"))
        commen!!.add(Commentary("1", "mario", "comentario 1", "1", "1"))
        commen!!.add(Commentary("1", "junito", "comentario 1", "1", "1"))
        commen!!.add(Commentary("1", "maria", "comentario 1", "1", "1"))
        commen!!.add(Commentary("1", "marianita", "comentario que no debe salir", "1", "2"))*/

        return commen!!
    }



}