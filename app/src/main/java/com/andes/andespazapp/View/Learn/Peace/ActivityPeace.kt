package com.andes.andespazapp.View.Learn.Peace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.andes.andespazapp.R
import com.andes.andespazapp.View.Learn.Memory.Receibe_activity
import kotlinx.android.synthetic.main.activity_.*

class ActivityPeace : AppCompatActivity() {


    private var Cardact1: CardView? = null
    private var Cardact2: CardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peace)
        Cardact1 = act1
        Cardact2 = act2
        Cardact1!!.setOnClickListener {
            var intent = Intent(this, Receibe_activity::class.java)
            intent.putExtra("title","Actividad 1")
            intent.putExtra("Text", "1. ¿cómo puedes implementar la paz desde tu mismo?\n\n" +
                    "2. ¿piensas que en Colombia actualmente si hay paz?\n\n" +
                    "3 identifica situaciones de la violencia en la casa, la escuela, el barrio los medios de comunicación y el Estado \n\n\n")
            this.startActivity(intent)


        }
        Cardact2!!.setOnClickListener {
            var intent = Intent(this, Receibe_activity::class.java)
            intent.putExtra("title","La corototeca")
            intent.putExtra("Text", "Crea en compañía de otro compañero un símbolo de paz, con los materiales que más te gusten, adelante deja volar tu imaginación e impone algo nuevo.\n" +
                    "Diseña una historieta donde puedas plasmar los diferentes tipos de violencia en tu país.\n\n\n")
            this.startActivity(intent)

        }
    }
}