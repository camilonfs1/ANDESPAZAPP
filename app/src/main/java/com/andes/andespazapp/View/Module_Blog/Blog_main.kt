package com.andes.andespazapp.View.Module_Blog

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andes.andespazapp.Model.BlogItem
import com.andes.andespazapp.R
import com.andes.andespazapp.View.Student.MainStudentMenu
import com.andes.andespazapp.ViewModel.Adapter.AdapterRecyclerHorizontal_blog
import com.andes.andespazapp.ViewModel.Adapter.AdapterRecyclerVertical_blog
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_dialog_main.*
import kotlinx.android.synthetic.main.activity_main.*

class Blog_main : AppCompatActivity() {

    // private lateinit var database: LocalDB
    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseReference: DatabaseReference? = null


    var main_blog_item_H: RecyclerView? = null
    var main_blog_item_V: RecyclerView? = null

    var home: Button? = null
    var post: Button? = null

    var adaptador_H: AdapterRecyclerHorizontal_blog? = null
    var adaptador_V: AdapterRecyclerVertical_blog? = null

    var layoutmanager: RecyclerView.LayoutManager? = null


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_main)
        val window: Window = this@Blog_main.window
        window.statusBarColor = ContextCompat.getColor(this@Blog_main, R.color.colorAccent)

        main_blog_item_H = recycler_blog_horizontal
        main_blog_item_V = recycler_blog_Vertical

        home = btn_home
        post = btn_postBlog


        var id = intent.getStringExtra("id")
        var username = intent.getStringExtra("username")
        var roll = intent.getStringExtra("roll")


        Toast.makeText(this,roll,Toast.LENGTH_SHORT).show()
        if(roll=="Instructor"){
            post!!.setVisibility(View.VISIBLE)
        }

        readDB(id,username)

        var internet =""
        val cm = baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnectedOrConnecting) {
            internet = "OK"
        } else {
            internet = "FAIL"
        }

        //Button home
        home!!.setOnClickListener {

            val intent = Intent(this, MainStudentMenu::class.java)
            intent.putExtra("id", id)
            intent.putExtra("username", username)
            intent.putExtra("internet", internet)
            startActivity(intent)
            this.finish()
        }


        //Button new blog
        post!!.setOnClickListener {
            maxkey(id, username)
        }
    }
    fun maxkey(id : String, username: String){
        var nums: ArrayList<Int> = ArrayList()
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.getReference().child("Blog")
        mDatabaseReference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (e in snapshot.children) {
                        var key = e.child("key").value.toString()
                        nums!!.add(Integer.parseInt(key))
                    }
                }
                var aux = 0
                for(i in nums){
                    if(i > aux){
                        aux=i
                    }
                }
                aux = aux+1
                post(id, username, aux.toString())
            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })

    }
    fun post(id : String, username: String, key:String){
        val intent = Intent(this, NewBlogItem::class.java)
        intent.putExtra("id", id)
        intent.putExtra("username", username)
        intent.putExtra("key", key)
        startActivity(intent)
        this.finish()
    }
    private fun readDB(id:String,username: String) {
        var items_blog: ArrayList<BlogItem> = ArrayList()
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference.child("Blog")
        mDatabaseReference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (e in snapshot.children) {
                        var key = e.child("key").value.toString()
                        var avatar_owner = e.child("key").value.toString()
                        var color = e.child("color").value.toString()
                        var date = e.child("date").value.toString()
                        var name_owner = e.child("name_owner").value.toString()
                        var num_commentari = e.child("num_commentari").value
                        var title = e.child("tittle").value.toString()
                        var dates = 0
                        if(date=="null"){
                            dates = 0
                        }else{
                            dates = Integer.parseInt(date)
                        }

                        var item = BlogItem(
                            Integer.parseInt(key),
                            name_owner,
                            title,
                            dates,
                            Integer.parseInt("1"),
                            Integer.parseInt(avatar_owner),
                            color
                        )
                        items_blog!!.add(item)

                    }
                    h(items_blog,id,username)
                    v(items_blog,id,username)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }

    fun h(items_blog: ArrayList<BlogItem>,id:String, username:String){
        //Horizontal recycler
        adaptador_H = AdapterRecyclerHorizontal_blog(items_blog,id,username)
        layoutmanager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        main_blog_item_H?.layoutManager = layoutmanager
        main_blog_item_H?.adapter = adaptador_H
    }

    fun v(items_blog: ArrayList<BlogItem>,id:String, username:String){
        //Vertical recycler
        adaptador_V = AdapterRecyclerVertical_blog(items_blog,id,username)
        layoutmanager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        main_blog_item_V?.layoutManager = layoutmanager
        main_blog_item_V?.adapter = adaptador_V

    }


}