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
import kotlinx.android.synthetic.main.activity_dialog_main.*

class Blog_main : AppCompatActivity() {

    var main_blog_item_H : RecyclerView? = null
    var main_blog_item_V: RecyclerView? = null
    var items: ArrayList<Blog_item>? = null
    var items_H: ArrayList<Blog_item>? = null
    var items_V: ArrayList<Blog_item>? = null
    var colors: ArrayList<String>? = null
    var layoutmanager: RecyclerView.LayoutManager? =  null
    var adaptador_H: AdapterRecyclerHorizontal_blog? = null
    var adaptador_V: AdapterRecyclerVertical_blog? = null
    var home: ImageView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_main)
        main_blog_item_H = recycler_blog_horizontal
        main_blog_item_V = recycler_blog_Vertical
        items = ArrayList()
        items_H = ArrayList()
        items_V = ArrayList()
        colors = ArrayList()
        home = image_home

        home!!.setOnClickListener {
            val intent = Intent(this, MainStudentMenu::class.java)
            startActivity(intent)
        }

        colors!!.add("#673AB7")
        colors!!.add("#7986CB")
        colors!!.add("#64B5F6")
        colors!!.add("#4FC3F7")
        colors!!.add("#4DD0E1")
        colors!!.add("#4DB6AC")
        colors!!.add("#81C784")
        colors!!.add("#AED581")
        colors!!.add("#DCE775")

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

        for (i in 0 until items!!.size){
            if(i<=8){
                items_H!!.add(items!!.get(i))
                items_H!!.get(i).color = colors!!.get(i)
            }else{
                items_V!!.add(items!!.get(i))
            }
        }

        layoutmanager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        adaptador_H = AdapterRecyclerHorizontal_blog(items_H!!, R.layout.blog_horizontal_item)
        main_blog_item_H?.layoutManager = layoutmanager
        main_blog_item_H?.adapter = adaptador_H

        items = ArrayList()

        layoutmanager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        adaptador_V = AdapterRecyclerVertical_blog(items_V!!, R.layout.blog_vertical_item)
        main_blog_item_V?.layoutManager = layoutmanager
        main_blog_item_V?.adapter = adaptador_V


    }


}