package com.andes.andespazapp.View.Module_Blog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.andes.andespazapp.DB.DB_Administrator
import com.andes.andespazapp.Model.Blog_item
import com.andes.andespazapp.Model.Firebase.Blog_Firebase
import com.andes.andespazapp.Model.User
import com.andes.andespazapp.R
import kotlinx.android.synthetic.main.activity_dialog_main.*
import kotlinx.android.synthetic.main.activity_new_blog_item.*

class NewBlogItem : AppCompatActivity() {
    private var post_button : Button? =null
    private var blog : Blog_Firebase?=null
    private var tittle: EditText? = null

    private var localDB : DB_Administrator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_blog_item)

        post_button = btn_newBlog
        tittle = txt_tittle
        //var id = 1.toString() //intent.getStringExtra("id")

        //Get data for user by id in local DB
        localDB = DB_Administrator(this)
        var user  = localDB!!.getUser("1111") 


        //Optain commentary num
        var key = localDB!!.maxcommentarynum()

        var item : Blog_item? = null

        if(user !is User){
           item =  Blog_item("12", "camilo vargas11", "DEBATE ANDES segunda", 1, 10, 1, "#fffff")
        }else{
            item =  Blog_item(
                "1",
                user.name.toString(),
                title.toString(),
                1,
                1,
                Integer.parseInt(user.icon.toString()),
                "#fffff"
            )
        }




        blog = Blog_Firebase()

        post_button!!.setOnClickListener {
            blog!!.new_blogItem(item!!)
        }



    }
}