package com.andes.andespazapp.View.Module_Blog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andes.andespazapp.Model.Blog_item
import com.andes.andespazapp.R
import com.andes.andespazapp.View.MainRegisterActivity
import com.andes.andespazapp.View.Student.MainStudentMenu
import com.andes.andespazapp.ViewModel.Adapter.AdapterRecyclerHorizontal_blog
import com.andes.andespazapp.ViewModel.Adapter.AdapterRecyclerVertical_blog
import com.andes.andespazapp.ViewModel.BlogViewModel
import kotlinx.android.synthetic.main.activity_dialog_main.*

class Blog_main : AppCompatActivity() {

    var main_blog_item_H : RecyclerView? = null
    var main_blog_item_V: RecyclerView? = null
    var home: ImageView?= null
    var ViewModel :BlogViewModel? = null
    var adaptador_H: AdapterRecyclerHorizontal_blog? = null
    var adaptador_V: AdapterRecyclerVertical_blog? = null
    var layoutmanager: RecyclerView.LayoutManager? =  null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_main)
        main_blog_item_H = recycler_blog_horizontal
        main_blog_item_V = recycler_blog_Vertical

        home = image_home
        ViewModel = BlogViewModel()

        adaptador_H = ViewModel!!.horizontalAd(this)
        layoutmanager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        main_blog_item_H?.layoutManager = layoutmanager
        main_blog_item_H?.adapter = adaptador_H

        //------------------------------------------------------------------------------------------

        adaptador_V = ViewModel!!.verticalAd(this)
        layoutmanager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        main_blog_item_V?.layoutManager = layoutmanager
        main_blog_item_V?.adapter = adaptador_V


        home!!.setOnClickListener {
            val intent = Intent(this, MainStudentMenu::class.java)
            startActivity(intent)
        }
    }


}