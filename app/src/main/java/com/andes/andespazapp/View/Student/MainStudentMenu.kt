package com.andes.andespazapp.View.Student

import android.content.ContentValues
import android.content.Intent
import android.media.Image
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.andes.andespazapp.DB.LocalDB
import com.andes.andespazapp.Model.Firebase.Login_Firebase
import com.andes.andespazapp.Model.Firebase.User_Firebase
import com.andes.andespazapp.Model.Person
import com.andes.andespazapp.R
import com.andes.andespazapp.View.CRUD.CRUD_Individual_User
import com.andes.andespazapp.View.Complaints.DDHH_Complaints
import com.andes.andespazapp.View.Complaints.Sent_Complaint
import com.andes.andespazapp.View.Learn.Main_Learn
import com.andes.andespazapp.View.MainActivity
import com.andes.andespazapp.View.Module_Blog.Blog_main
import com.andes.andespazapp.View.Vinculate.Vinculate_Sent
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main_student_menu.*

class MainStudentMenu : AppCompatActivity() {
   // private lateinit var database: LocalDB



    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mUserReference: DatabaseReference? = null

    val user1 = Firebase.auth.currentUser

    private var userLocal: Person? = null

    var name: TextView? =null
    var roll: TextView? = null

    var image: ImageView? = null

    var btn_blog: CardView? = null
    var btn_complain: CardView? = null
    var btn_profile: CardView? = null
    var btn_ddhh: CardView? = null
    var btn_close_back: CardView? = null
    var btn_lear: CardView? = null
    var txt_name:TextView? = null
    var btn_andes:CardView? = null
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_student_menu)

        name = txt_name_student
        roll = txt_roll
        image =image_student

        btn_andes =andesbtn

        //database = LocalDB.getDatabase(this)


       var id = intent.getStringExtra("id")

        if(id=="" || id ==null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else{
            /*var res = database.persons().get(id.toInt()).value
            name!!.text=res!!.name
            roll!!.text = res!!.roll*/
            readDB(id)
        }

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

        var roll = intent.getStringExtra("roll")

        if(roll == "" || id ==""){
            startActivity(Intent(this, MainActivity::class.java))
        }

        btn_close_back!!.setOnClickListener{
            SigOut()
        }

        var firebase = User_Firebase()
        btn_profile!!.setOnClickListener{
            val emailAddress = "camilonfs1@gmail.com"
            user1
            System.out.println("")

            Firebase.auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(ContentValues.TAG, "Email sent.")
                    }
                }

        /*
            val intent = Intent(this, CRUD_Individual_User::class.java)
            intent.putExtra("id", "123456")
            startActivity(intent)*/
        }
        btn_andes!!.setOnClickListener{
            val intent = Intent(this, Vinculate_Sent::class.java)
            intent.putExtra("id", id)
            intent.putExtra("username",txt_name!!.text)
            startActivity(intent)
        }

        btn_lear!!.setOnClickListener{
            val intent = Intent(this, Main_Learn::class.java)
            startActivity(intent)
        }
        btn_blog!!.setOnClickListener{
            val intent = Intent(this, Blog_main::class.java)
            intent.putExtra("id", id)
            intent.putExtra("username",txt_name!!.text)
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
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun readDB(id: String) {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference
        mUserReference = mDatabaseReference!!.child("Usuarios")
        mUserReference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (e in snapshot.children) {
                        var key = e.child("Id").value
                        if(key == id){
                            var Nombre = e.child("Nombre").value.toString()
                            var Roll = e.child("Roll").value.toString()
                            var Edad = e.child("Edad").value.toString()
                            var Region = e.child("Region").value.toString()
                            var Andes = e.child("Andes").value as Boolean
                            var Email = e.child("Email").value.toString()
                            var icon = Integer.parseInt(e.child("icon").value.toString())
                            var user = Person(
                                Roll!!,
                                Andes!!,
                                Nombre,
                                Integer.parseInt(key.toString()),
                                Region,
                                Edad,
                                Email,
                                icon
                            )
                            putuser(user)
                        }
                    }


                } else {

                }
            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }

    fun putuser(user:Person){
        this.userLocal = user
        txt_name!!.text = userLocal!!.name
        txt_roll!!.text = userLocal!!.roll
        if(user.icon==1){
            image!!.setImageResource(R.drawable.icon_1)
        }else if(user.icon==2){
            image!!.setImageResource(R.drawable.icon_2)
        }else if(user.icon==3){
            image!!.setImageResource(R.drawable.icon_3)
        }else if(user.icon==4){
            image!!.setImageResource(R.drawable.icon_4)
        }else if(user.icon==5){
            image!!.setImageResource(R.drawable.icon_5)
        }else if(user.icon==6){
            image!!.setImageResource(R.drawable.icon_6)
        }else if(user.icon==7){
            image!!.setImageResource(R.drawable.icon_7)
        }else if(user.icon==8){
            image!!.setImageResource(R.drawable.icon_8)
        }else if(user.icon==9){
            image!!.setImageResource(R.drawable.icon_9)
        }else if(user.icon==10){
            image!!.setImageResource(R.drawable.icon_10)
        }
        else if(user.icon==11){
            image!!.setImageResource(R.drawable.icon_11)
        }
        else if(user.icon==12){
            image!!.setImageResource(R.drawable.icon_12)
        }


    }





}


