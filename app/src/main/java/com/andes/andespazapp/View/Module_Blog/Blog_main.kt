package com.andes.andespazapp.View.Module_Blog

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.widget.Button
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



        readDB(id)



        //Button home
        home!!.setOnClickListener {
            val intent = Intent(this, MainStudentMenu::class.java)
            intent.putExtra("id", id)
            intent.putExtra("username", username)
            startActivity(intent)
        }

        //Button new blog
        post!!.setOnClickListener {
            val intent = Intent(this, NewBlogItem::class.java)
            intent.putExtra("id", id)
            intent.putExtra("username", username)
            startActivity(intent)
        }
    }
    private fun readDB(id:String) {
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
                        System.out.println("aca esta el error "+date)
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
                            Integer.parseInt(num_commentari.toString()),
                            Integer.parseInt(avatar_owner),
                            color
                        )
                        items_blog!!.add(item)

                    }
                    h(items_blog,id)
                    v(items_blog)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }

    fun h(items_blog: ArrayList<BlogItem>,id:String){
        //Horizontal recycler
        adaptador_H = AdapterRecyclerHorizontal_blog(items_blog,id)
        layoutmanager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        main_blog_item_H?.layoutManager = layoutmanager
        main_blog_item_H?.adapter = adaptador_H
    }
    fun v(items_blog: ArrayList<BlogItem>){
        //Vertical recycler
        adaptador_V = AdapterRecyclerVertical_blog(items_blog)
        layoutmanager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        main_blog_item_V?.layoutManager = layoutmanager
        main_blog_item_V?.adapter = adaptador_V

    }


}