package com.andes.andespazapp.View.Student

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.andes.andespazapp.DB.DB_Administrator
import com.andes.andespazapp.R
import com.andes.andespazapp.View.CRUD.CRUD_Individual_User
import com.andes.andespazapp.View.Complaints.Receive_Complaints
import com.andes.andespazapp.View.Complaints.Sent_Complaint
import com.andes.andespazapp.View.Learn.Main_Learn
import com.andes.andespazapp.View.Module_Blog.Blog_main
import kotlinx.android.synthetic.main.activity_main_student_menu.*

class MainStudentMenu : AppCompatActivity() {
    var btn_blog: CardView? = null
    var btn_complain: CardView? = null
    var btn_profile: CardView? = null


    var btn_lear: CardView? = null
    var txt_name:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_student_menu)
        btn_complain = btn_complaint
        btn_blog = card_blog_student
        btn_profile = profile_student_card
        btn_lear = btn_learn
        txt_name = txt_name_student

        /*var db = DB_Administrator(this)
        var user = db.readData("6")

        txt_name!!.setText(user.id)*/

        btn_profile!!.setOnClickListener{
            val intent = Intent(this, CRUD_Individual_User::class.java)
            intent.putExtra("id", "123456")
            startActivity(intent)
        }


        btn_lear!!.setOnClickListener{
            val intent = Intent(this, Main_Learn::class.java)
            startActivity(intent)
        }
        btn_blog!!.setOnClickListener{
            val intent = Intent(this, Blog_main::class.java)
            startActivity(intent)
        }
        btn_complain!!.setOnClickListener{
            val intent = Intent(this, Sent_Complaint::class.java)
            startActivity(intent)
        }
    }

}