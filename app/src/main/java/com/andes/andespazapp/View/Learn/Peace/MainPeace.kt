package com.andes.andespazapp.View.Learn.Peace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.andes.andespazapp.R
import com.andes.andespazapp.View.Learn.Diversity.SchoolDiversity
import kotlinx.android.synthetic.main.activity_main_peace.*

class MainPeace : AppCompatActivity() {
    private var card1:CardView?=null
    private var card2:CardView?=null
    private var card3:CardView?=null
    private var card4:CardView?=null
    private var card5:CardView?=null
    private var card6:CardView?=null
    private var card7:CardView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_peace)

        card1=card_tipos
        card2=card_violenciacolombia
        card5=card_simbolos
        card7=card_activity

        card1!!.setOnClickListener {
            var intent = Intent(this, TiposDeViolencia::class.java)
            this.startActivity(intent)
        }
        card2!!.setOnClickListener {
            var intent = Intent(this, ViolenciaEnColombia::class.java)
            this.startActivity(intent)
        }

        card5!!.setOnClickListener {
            var intent = Intent(this, SimbolosPaz::class.java)
            this.startActivity(intent)
        }
        card7!!.setOnClickListener {
            var intent = Intent(this, ActivityPeace::class.java)
            this.startActivity(intent)
        }

    }
}