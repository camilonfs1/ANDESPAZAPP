package com.andes.andespazapp.View.Module_Blog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.andes.andespazapp.DB.LocalDB
import com.andes.andespazapp.Model.BlogItem
import com.andes.andespazapp.Model.Firebase.Blog_Firebase
import com.andes.andespazapp.R
import kotlinx.android.synthetic.main.activity_new_blog_item.*

class NewBlogItem : AppCompatActivity() {
    private var post_button: Button? = null
    private var back_button: Button? = null
    private var blog: Blog_Firebase? = null
    private var title: EditText? = null

    private lateinit var database: LocalDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_blog_item)

        post_button = btn_newBlog
        back_button = btn_back

        title = post_text

        var id = intent.getStringExtra("id")
        var username = intent.getStringExtra("username")
        var key = intent.getStringExtra("key")
        //Get data for user by id in local DB
        database = LocalDB.getDatabase(this)

        post_button!!.setOnClickListener {
            create(Integer.parseInt(key), id, username)
            post_text.text.clear()
        }
        back_button!!.setOnClickListener {
            val intent = Intent(this, Blog_main::class.java)
            intent.putExtra("id", id)
            intent.putExtra("username", username)
            startActivity(intent)
            this.finish()
        }

    }


    fun create(max: Int, id: String, username: String) {

        blog = Blog_Firebase()


        var item: BlogItem? = null

        var texto = title!!.text.toString()

        var text_lenght = texto.length

        if(text_lenght>100){
            Toast.makeText(this,"Muy largo", Toast.LENGTH_LONG).show()
        }

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

        blog = Blog_Firebase()

        Toast.makeText(this, title!!.text.toString(), Toast.LENGTH_LONG).show()


    }
}