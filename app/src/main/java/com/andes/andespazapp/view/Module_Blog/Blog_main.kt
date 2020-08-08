package com.andes.andespazapp.view.Module_Blog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andes.andespazapp.Model.Blog_item
import com.andes.andespazapp.R
import com.andes.andespazapp.ViewModel.Adapter.AdapterRecyclerHorizontal_blog
import kotlinx.android.synthetic.main.activity_dialog_main.*

class Blog_main : AppCompatActivity() {

    var main_blog_item_H : RecyclerView? = null
    var main_blog_item_V: RecyclerView? = null
    var items: ArrayList<Blog_item>? = null
    var layoutmanager: RecyclerView.LayoutManager? =  null
    var adaptador: AdapterRecyclerHorizontal_blog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_main)
        main_blog_item_H = recycler_blog_horizontal
        main_blog_item_V = recycler_blog_Vertical
        items = ArrayList()

        items!!.add(Blog_item("1", "camilo vargas",   "Discusión numero uno, propuesta para el desarrollo del tema propuesta", 1, 1, 1,1))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES segunda", 1, 1, 1,1))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES tercera", 1, 1, 1,1))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES cuarta", 1, 1, 1,1))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES quinta", 1, 1, 1,1))

        layoutmanager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        adaptador = AdapterRecyclerHorizontal_blog(items!!, R.layout.blog_horizontal_item)

        main_blog_item_H?.layoutManager = layoutmanager
        main_blog_item_H?.adapter = adaptador


        layoutmanager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        adaptador = AdapterRecyclerHorizontal_blog(items!!, R.layout.blog_vertical_item)

        main_blog_item_V?.layoutManager = layoutmanager
        main_blog_item_V?.adapter = adaptador


    }


}