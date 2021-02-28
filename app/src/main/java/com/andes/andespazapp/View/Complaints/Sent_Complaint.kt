package com.andes.andespazapp.View.Complaints

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.andes.andespazapp.R
import kotlinx.android.synthetic.main.activity_sent__complaint.*

class Sent_Complaint : AppCompatActivity() {

    var txt:EditText?=null
    var contact:EditText?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sent__complaint)
        txt = text_complaint
    }
}