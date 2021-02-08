package com.andes.andespazapp.View.Module_Blog

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andes.andespazapp.R
import com.andes.andespazapp.View.Student.MainStudentMenu
import com.andes.andespazapp.ViewModel.Adapter.AdapterRecyclerHorizontal_blog
import com.andes.andespazapp.ViewModel.Adapter.AdapterRecyclerVertical_blog
import kotlinx.android.synthetic.main.activity_dialog_main.*

class Blog_main : AppCompatActivity() {

    var main_blog_item_H: RecyclerView? = null
    var main_blog_item_V: RecyclerView? = null

    var home: ImageView? = null

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

        home = image_home

        //Horizontal recycler
        adaptador_H = AdapterRecyclerHorizontal_blog(this)
        layoutmanager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        main_blog_item_H?.layoutManager = layoutmanager
        main_blog_item_H?.adapter = adaptador_H

        //Vertical recycler
        adaptador_V = AdapterRecyclerVertical_blog(this)
        layoutmanager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        main_blog_item_V?.layoutManager = layoutmanager
        main_blog_item_V?.adapter = adaptador_V

        //Button home
        home!!.setOnClickListener {
            val intent = Intent(this, MainStudentMenu::class.java)
            startActivity(intent)
        }
    }


}