package com.andes.andespazapp.View.Learn.Gender

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.andes.andespazapp.R
import com.andes.andespazapp.View.Learn.Memory.Receibe_activity
import kotlinx.android.synthetic.main.activity_.*

class ActivityGender : AppCompatActivity() {
    private var Cardact1 : CardView? =null
    private var Cardact2 : CardView? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gender)
        Cardact1 = act1
        Cardact2 = act2
        Cardact1!!.setOnClickListener {
            var intent = Intent(this, Receibe_activity::class.java)
            intent.putExtra("title","Genero")
            intent.putExtra("Text", "1. ¿si hubieras nacido en la época que a la mujer se le veía como minoría, y fueras el encargado de proponer derechos a todos los ciudadanos cuáles hubieran sido?\n\n" +
                    "2. ¿Piensas que aun a las mujeres les falta por avanzar para tener una igualdad con los hombres?, explícanos tu respuesta.\n")
            this.startActivity(intent)


        }
        Cardact2!!.setOnClickListener {
            var intent = Intent(this, Receibe_activity::class.java)
            intent.putExtra("title","Actividad didáctica:")
            intent.putExtra("Text", "1.Organiza una obra de teatro con tus compañeros sin importar el número de integrantes, representando alguna época en cuanto a la historia del feminismo que te haya llamado la atención \n\n")
            this.startActivity(intent)

        }
    }
}