package com.andes.andespazapp.View.Learn.Diversity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.andes.andespazapp.R
import com.andes.andespazapp.View.Learn.Memory.Receibe_activity
import kotlinx.android.synthetic.main.activity_.*

class ActivityDiversity : AppCompatActivity() {
    private var Cardact1 : CardView? =null
    private var Cardact2 : CardView? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diversity)

        Cardact1 = act1
        Cardact2 = act2
        Cardact1!!.setOnClickListener {
            var intent = Intent(this, Receibe_activity::class.java)
            intent.putExtra("title","L.G.B.T.I.Q")
            intent.putExtra("Text", "Qué piensas de las personas L.G.B.T.I.\n\n" +
                    "Piensas que en Colombia manejamos la homofobia\n\n")
            this.startActivity(intent)


        }
        Cardact2!!.setOnClickListener {
            var intent = Intent(this, Receibe_activity::class.java)
            intent.putExtra("title","Actividad didáctica:")
            intent.putExtra("Text", "literatura infantil, pendiente https://www.orientacionriojabaja.info/diversidad-sexual-en-educacion/\n\n")
            this.startActivity(intent)

        }
    }
}