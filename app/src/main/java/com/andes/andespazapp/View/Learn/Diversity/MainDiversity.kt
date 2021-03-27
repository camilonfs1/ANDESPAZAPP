package com.andes.andespazapp.View.Learn.Diversity

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.andes.andespazapp.R
import com.andes.andespazapp.View.Learn.Memory.Activity
import kotlinx.android.synthetic.main.activity_main_diversity.*

class MainDiversity : AppCompatActivity() {
    var card_1: CardView? = null
    var card_2: CardView? = null
    var card_3: CardView? = null
    var card_4: CardView? = null

    var card_L_: CardView? = null
    var card_G_: CardView? = null
    var card_B_: CardView? = null
    var card_T_: CardView? = null
    var card_I_: CardView? = null
    var card_Q_: CardView? = null

    private var myDialog0: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_diversity)

        myDialog0 = Dialog(this)

        card_1 = card_diversidadenlaescual
        card_2 = card_queesladiversidad
        card_3 = card_historia
        card_4 = card_actividad

        card_L_ = card_L
        card_G_ = card_G
        card_B_ = card_B
        card_T_ = card_T
        card_I_ = card_I
        card_Q_ = card_Q

        card_1!!.setOnClickListener {
            var intent = Intent(this, SchoolDiversity::class.java)
            this.startActivity(intent)
        }
        card_2!!.setOnClickListener {
            var intent = Intent(this, WhatIs::class.java)
            this.startActivity(intent)
        }
        card_3!!.setOnClickListener {
            var intent = Intent(this, History::class.java)
            this.startActivity(intent)
        }
        card_4!!.setOnClickListener {
            var intent = Intent(this, ActivityDiversity::class.java)
            this.startActivity(intent)
        }

        card_L!!.setOnClickListener {
            showPopUp("La «L» es de lesbianas: personas que se identifican como mujeres y se sienten atraídas hacia otras personas que también se identifican como mujeres.")
        }
        card_G!!.setOnClickListener {
            showPopUp("La «G» es de gays: personas que se identifican como hombres y se sienten atraídas hacia otras personas que también se identifican como hombres.")
        }
        card_B!!.setOnClickListener {
            showPopUp("La «B» es de bisexual: personas que se sienten atraídas tanto hacia personas de que se identifican como mujeres como a personas que se identifican como hombres.")
        }
        card_T!!.setOnClickListener {
            showPopUp("La «T» es de trans. Este se considera un término «paraguas» ya que se utiliza en diferentes sentidos. En general se usa para describir a personas cuya identidad de género no se corresponde con su sexo biológico. Muchas veces se diferencia entre travestis, transgénero y transexuales; en esos casos es posible ver la sigla como LGBTTTIQ.")
        }
        card_I!!.setOnClickListener {
            showPopUp("La «I» es de intersex: personas cuyo sexo biológico no se ajusta a la definición binaria hombre/mujer. Existen múltiples combinaciones de atributos sexuales que no se ajustan a ninguna de las dos categorías mencionadas.")
        }
        card_Q!!.setOnClickListener {
            showPopUp("La «Q» es de queer («raro», en inglés): originalmente utilizado en tono despectivo para hablar de toda aquella persona que no se ajustara a los parámetros de la heterosexualidad.")
        }
    }

    private fun showPopUp(text1: String) {
        myDialog0!!.setContentView(R.layout.popupthreep_mini)
        var close: TextView = myDialog0!!.findViewById(R.id.txtClose)
        var text: TextView = myDialog0!!.findViewById(R.id.text)

        text.setText(text1)

        close.setOnClickListener {
            myDialog0!!.dismiss()
        }
        myDialog0!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialog0!!.show()
    }
}