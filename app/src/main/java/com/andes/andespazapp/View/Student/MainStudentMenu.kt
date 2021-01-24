package com.andes.andespazapp.View.Student

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.andes.andespazapp.DB.DB_Administrator
import com.andes.andespazapp.Model.User
import com.andes.andespazapp.R
import com.andes.andespazapp.View.CRUD.CRUD_Individual_User
import com.andes.andespazapp.View.Complaints.DDHH_Complaints
import com.andes.andespazapp.View.Complaints.Sent_Complaint
import com.andes.andespazapp.View.Learn.Main_Learn
import com.andes.andespazapp.View.MainActivity
import com.andes.andespazapp.View.Module_Blog.Blog_main
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main_student_menu.*

class MainStudentMenu : AppCompatActivity() {
    var databaseHandler: DB_Administrator?=null
    var mAuth: FirebaseAuth? = null

    var name: TextView? =null
    var roll: TextView? = null

    var btn_blog: CardView? = null
    var btn_complain: CardView? = null
    var btn_profile: CardView? = null
    var btn_ddhh: CardView? = null
    var btn_close_back: CardView? = null
    var btn_lear: CardView? = null
    var txt_name:TextView? = null
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_student_menu)

        name = txt_name_student
        roll = txt_roll



       /* var id = intent.getStringExtra("id")
        if(id=="" || id ==null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else{
            var res = databaseHandler!!.getUser(id) as User
            name!!.text=res.name
            roll!!.text = res.roll
        }*/
        databaseHandler = DB_Administrator(this)





        //This lines change statusBarcolor by specific color in colors.xml
        val window: Window = this@MainStudentMenu.window
        window.statusBarColor = ContextCompat.getColor(this@MainStudentMenu, R.color.color3)

        btn_complain = btn_complaint
        btn_blog = card_blog_student
        btn_profile = profile_student_card
        btn_lear = btn_learn
        txt_name = txt_name_student
        btn_ddhh = ddhh_card
        btn_close_back = btn_close

       /* var id = intent.getStringExtra("id")
        var roll = intent.getStringExtra("roll")

        if(roll == "" || id ==""){
            startActivity(Intent(this, MainActivity::class.java))
        }*/


        /*var db = DB_Administrator(this)
        var user = db.readData("6")

        txt_name!!.setText(user.id)*/

        btn_close_back!!.setOnClickListener{
            SigOut()
        }

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
        btn_ddhh!!.setOnClickListener{
            val intent = Intent(this, DDHH_Complaints::class.java)
            startActivity(intent)
        }
    }
    fun SigOut() {
        mAuth!!.signOut()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }


}


