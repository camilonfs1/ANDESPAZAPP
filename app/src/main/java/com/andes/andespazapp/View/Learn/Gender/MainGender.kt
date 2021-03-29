package com.andes.andespazapp.View.Learn.Gender

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.andes.andespazapp.R
import com.andes.andespazapp.View.Learn.Diversity.SchoolDiversity
import kotlinx.android.synthetic.main.activity_main_gender.*

class MainGender : AppCompatActivity() {
    private var card1:CardView?=null
    private var card2:CardView?=null
    private var card3:CardView?=null
    private var card4:CardView?=null
    private var card5:CardView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_gender)

        card1=card_8
        card2=card_feminismos
        card3=card_patriarcado
        card4=card_aulas
        card5=card_actividades

        card1!!.setOnClickListener {
            var intent = Intent(this, March8::class.java)
            this.startActivity(intent)
        }
        card2!!.setOnClickListener {
            var intent = Intent(this, FeminismTypes::class.java)
            this.startActivity(intent)
        }
        card3!!.setOnClickListener {
            var intent = Intent(this, Patriarcado::class.java)
            this.startActivity(intent)
        }
        card4!!.setOnClickListener {
            var intent = Intent(this, SchoolWomen::class.java)
            this.startActivity(intent)
        }
        card5!!.setOnClickListener {
            var intent = Intent(this, ActivityGender::class.java)
            this.startActivity(intent)
        }
    }
}