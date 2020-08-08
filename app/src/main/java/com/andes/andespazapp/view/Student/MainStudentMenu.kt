package com.andes.andespazapp.view.Student

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.andes.andespazapp.Model.Blog_item
import com.andes.andespazapp.R
import com.andes.andespazapp.view.Module_Blog.Blog_main
import kotlinx.android.synthetic.main.activity_main_student_menu.*

class MainStudentMenu : AppCompatActivity() {
    var btn_blog: CardView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_student_menu)

        btn_blog = card_blog_student

        btn_blog!!.setOnClickListener{
            val intent = Intent(this, Blog_main::class.java)
            startActivity(intent)
        }
    }


}