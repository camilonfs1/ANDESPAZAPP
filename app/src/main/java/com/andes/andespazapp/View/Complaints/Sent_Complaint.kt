package com.andes.andespazapp.View.Complaints

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.andes.andespazapp.Model.Complaint
import com.andes.andespazapp.Model.Firebase.Compaint_firebase
import com.andes.andespazapp.R
import kotlinx.android.synthetic.main.activity_sent__complaint.*

class Sent_Complaint : AppCompatActivity() {

    var txt:EditText?=null
    var contact:EditText?=null

    var btn: Button?=null

    var firebase = Compaint_firebase()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sent__complaint)
        txt = text_complaint
        contact = txt_contact
        btn=btn_complaint

        btn!!.setOnClickListener {
            var complaint = Complaint(txt!!.text.toString(),contact!!.text.toString())
            firebase.new_complaint(complaint)
            clear()
            Toast.makeText(this,"GRACIAS", Toast.LENGTH_LONG).show()
        }
    }
    fun clear(){
        txt!!.text.clear()
        contact!!.text.clear()
    }
}
