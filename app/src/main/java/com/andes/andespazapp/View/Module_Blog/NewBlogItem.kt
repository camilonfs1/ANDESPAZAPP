package com.andes.andespazapp.View.Module_Blog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.andes.andespazapp.Model.Blog_item
import com.andes.andespazapp.Model.Firebase.Blog_Firebase
import com.andes.andespazapp.R
import kotlinx.android.synthetic.main.activity_new_blog_item.*

class NewBlogItem : AppCompatActivity() {
    private var post_button : Button? =null
    private var blog : Blog_Firebase?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_blog_item)

        post_button = post_btn

        var item: Blog_item? =  Blog_item(
            "1",
            "camilo vargas0",
            "Discusión numero uno, propuesta para el desarrollo del tema propuesta",
            1,
            1,
            1,
            "#fffff"
        )

        blog = Blog_Firebase()

        post_button!!.setOnClickListener {
            blog!!.new_blogItem(item!!)
        }



    }
}