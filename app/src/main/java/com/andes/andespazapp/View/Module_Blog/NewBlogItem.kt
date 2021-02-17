package com.andes.andespazapp.View.Module_Blog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import com.andes.andespazapp.DB.LocalDB
import com.andes.andespazapp.Model.BlogItem
import com.andes.andespazapp.Model.Firebase.Blog_Firebase
import com.andes.andespazapp.Model.Person
import com.andes.andespazapp.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_new_blog_item.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewBlogItem : AppCompatActivity() {
    private var post_button: Button? = null
    private var blog: Blog_Firebase? = null
    private var title: EditText? = null

    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseReference: DatabaseReference? = null

    private lateinit var database: LocalDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_blog_item)

        post_button = btn_newBlog
        title = post_text

        var id = intent.getStringExtra("id")
        var username = intent.getStringExtra("username")
        //Get data for user by id in local DB
        database = LocalDB.getDatabase(this)

        //Optain commentary num
        var key = 0

        post_button!!.setOnClickListener {
            maxkey(Integer.parseInt(id),username)
        }


    }

    fun maxkey(id: Int,username:String){
        var nums: ArrayList<Int> = ArrayList()
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference.child("Blog")
        mDatabaseReference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (e in snapshot.children) {
                        var key = e.child("key").value as String
                        nums!!.add(Integer.parseInt(key))
                    }
                    create(nums,id,username)
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }

    fun create(listnums : ArrayList<Int>,id: Int,username:String){
        blog = Blog_Firebase()

        var max = 0
        for(i in listnums){
            if(i>max){
                max = i
            }
        }

        max = max+1
        var item: BlogItem? = null

        var texto = title!!.text.toString()
            item = BlogItem(
                max,
                username,
                texto,
                1,
                1,
                0,
                "#fffff"
            )

        blog!!.new_blogItem(item!!)
        Toast.makeText(this, title!!.text.toString(), Toast.LENGTH_LONG).show()
        val intent = Intent(this, Blog_main::class.java)
        intent.putExtra("id", id)
        startActivity(intent)


    }
}