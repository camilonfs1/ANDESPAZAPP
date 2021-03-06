package com.andes.andespazapp.Model.Firebase

import android.content.Context
import com.andes.andespazapp.Model.BlogItem
import com.andes.andespazapp.Model.Commentary
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

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
        mDatabaseReference!!.child("name_owner").setValue(blogItem.name_owner)
        mDatabaseReference!!.child("tittle").setValue(blogItem.title)
        mDatabaseReference!!.child("date").setValue(blogItem.date.toString())
        mDatabaseReference!!.child("num_commentari").setValue(blogItem.num_commentari.toString())
        mDatabaseReference!!.child("avatar_owner").setValue(blogItem.avatar_owner.toString())
        mDatabaseReference!!.child("color").setValue(blogItem.color)

    }

    fun new_commentary(commentary: Commentary, key: String) {
        val ref = FirebaseDatabase.getInstance().getReference("/Commentary/${key}").push()
        ref.setValue(commentary)
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