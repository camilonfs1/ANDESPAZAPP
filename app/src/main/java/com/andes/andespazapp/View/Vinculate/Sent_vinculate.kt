package com.andes.andespazapp.View.Vinculate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView
import com.andes.andespazapp.R
import kotlinx.android.synthetic.main.activity_sent_vinculate.*

class Sent_vinculate : AppCompatActivity() {
    private var sent: Button? = null
    private var back: Button? = null
    private var name: String? = null
    private var tel: String? = null
    private var region: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sent_vinculate)

        sent = btn_sent_vinculate

        back = back_button

        var id = intent.getStringExtra("id")

        back!!.setOnClickListener{
            val intent = Intent(this, Sent_vinculate::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }
        sent!!.setOnClickListener {
            //Get data

            name = txt_name_register.text.toString()
            tel = txt_tel_register.text.toString()
            region = txt_region.text.toString()

            

            //Save to firebase

        }
    }
}