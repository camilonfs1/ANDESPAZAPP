package com.andes.andespazapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.andes.andespazapp.R
import com.andes.andespazapp.view.Student.MainStudentMenu
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var register: TextView? = null
    private var mAuth: FirebaseAuth? = null
    private var btn_enter: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        register = txt_register
        btn_enter = btn_inter

        mAuth = FirebaseAuth.getInstance()

        btn_enter!!.setOnClickListener{
            val intent = Intent(this, MainStudentMenu::class.java)
            startActivity(intent)
        }
        register!!.setOnClickListener {
            val intent = Intent(this, MainRegisterActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth!!.currentUser
    }
}