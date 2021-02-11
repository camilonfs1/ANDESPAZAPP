package com.andes.andespazapp.View.Module_Blog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
    private var title: EditText? = null

    private var localDB : DB_Administrator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_blog_item)

        post_button = btn_newBlog
        title = post_text


        var id = intent.getStringExtra("id")
        System.out.println("--------------------------------keeeeeey"+id)
        //Get data for user by id in local DB
        localDB = DB_Administrator(this)

        var user  = localDB!!.getUser(id.toString())



        //Optain commentary num
        var key = localDB!!.maxcommentarynum()+ 1





        blog = Blog_Firebase()



        post_button!!.setOnClickListener {
            var item : Blog_item? = null

            var texto = title!!.text.toString()

            if(user !is User){
                item =  Blog_item("12", "camilo vargas11", "DEBATE ANDES segunda", 1, 10, 1, "#fffff")
            }else{
                item =  Blog_item(
                    key.toString(),
                    user.name.toString(),
                    texto,
                    1,
                    1,
                    Integer.parseInt(user.icon.toString()),
                    "#fffff"
                )
            }

            localDB!!.write_blogitem(item)


            blog!!.new_blogItem(item!!)
            Toast.makeText(this,title!!.text.toString(), Toast.LENGTH_LONG).show()
            val intent = Intent(this, Blog_main::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }



    }
}