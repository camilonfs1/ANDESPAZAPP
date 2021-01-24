package com.andes.andespazapp.View

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.andes.andespazapp.DB.DB_Administrator
import com.andes.andespazapp.Model.User
import com.andes.andespazapp.R
import com.andes.andespazapp.View.Student.MainStudentMenu
import com.andes.andespazapp.ViewModel.Login_ViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var register: TextView? = null
    private var btn_enter: Button? = null
    private var txt_email: TextInputEditText? =null
    private var txt_pass: TextInputEditText?=null

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_email = input_email
        txt_pass = input_password
        register = txt_register
        btn_enter = btn_inter

        var login = Login_ViewModel()
        btn_enter!!.setOnClickListener{

            /*if(txt_email!!.text.toString()==""||txt_pass!!.text.toString()==""){
                Toast.makeText(this,"Ingresa los datos completos",Toast.LENGTH_LONG).show()
            }else{
                login.login_funtion(this,txt_email!!.text.toString(),txt_pass!!.text.toString())
            }*/



            val intent = Intent(this, MainStudentMenu::class.java)
            startActivity(intent)
        }
        register!!.setOnClickListener {
            val intent = Intent(this, MainRegisterActivity::class.java)
            startActivity(intent)
        }
    }



}