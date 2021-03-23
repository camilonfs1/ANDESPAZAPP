package com.andes.andespazapp.View.Learn.Memory

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.andes.andespazapp.R
import kotlinx.android.synthetic.main.activity_learn1.*

class Learn1 : AppCompatActivity() {

    private var btn_y: Button? = null
    private var btn_n: Button? = null
    private var btn_acti: CardView? = null
    private var content: ScrollView? = null

    private var introduction: CardView? = null
    private var justify: CardView? = null
    private var how_card: CardView? = null
    private var make_card: CardView? = null
    private var why_card: CardView? = null
    private var org_card: CardView? = null
    private var extr_card: CardView? = null
    private var ref_card: CardView? = null

    private var myDialog0: Dialog?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn1)

        myDialog0 = Dialog(this)

        btn_y = btn_yes
        btn_n = btn_no
        content = conten_scroll

        introduction = Intro_card
        how_card = How_is_importand
        make_card = make_memory
        why_card = why_importand
        org_card = many_organizations
        justify = CardJustificationM
        btn_acti = activity_memory
        extr_card = CardExtras
        ref_card = card_reflection

        extr_card!!.setOnClickListener {
            var intent = Intent(this, Extra::class.java)
            this.startActivity(intent)
        }
        ref_card!!.setOnClickListener {
            showPopUp(" showPopUp(\" En un país como Colombia la memoria histórica es un elemento importante, porque su sociedad es una sociedad que ha sido atravesada por la violencia, de esta manera la memoria aporta a la verdad, a la reconstrucción del tejido social y también ayuda a la comprensión colectiva de la violencia y sus impactos en las comunidades. La memoria es una herramienta para el reconocimiento del pasado, un relato que hace un llamado a la justicia, a la reparación y a las garantías de no repetición. Gracias al ejercicio de la memoria las víctimas pueden ser reparadas y de esta manera poder caminar como sociedad hacia un futuro en paz.\n" +
                    " La memoria histórica es fundamental para la construcción de relaciones rotas y una paz sostenible en las sociedades divididas. (Lederach y Fisas, 1998)\n" )

        }

        btn_n!!.setOnClickListener {
            btn_y!!.visibility = View.INVISIBLE
            btn_n!!.visibility = View.INVISIBLE
            content!!.visibility = View.VISIBLE
        }
        btn_y!!.setOnClickListener {
            var intent = Intent(this, Activity::class.java)
            this.startActivity(intent)
        }
        btn_acti!!.setOnClickListener {
            var intent = Intent(this, Activity::class.java)
            this.startActivity(intent)
        }
        introduction!!.setOnClickListener {
            showPopUp(" En un país como Colombia la memoria histórica es un elemento importante, porque su sociedad es una sociedad que ha sido atravesada por la violencia, de esta manera la memoria aporta a la verdad, a la reconstrucción del tejido social y también ayuda a la comprensión colectiva de la violencia y sus impactos en las comunidades. La memoria es una herramienta para el reconocimiento del pasado, un relato que hace un llamado a la justicia, a la reparación y a las garantías de no repetición. Gracias al ejercicio de la memoria las víctimas pueden ser reparadas y de esta manera poder caminar como sociedad hacia un futuro en paz.\n" +
                    " \"La memoria histórica es fundamental para la construcción de relaciones rotas y una paz sostenible en las sociedades divididas\". (Lederach y Fisas, 1998)")

        }
        how_card!!.setOnClickListener {
            var intent = Intent(this, Necesary_Memory::class.java)
            this.startActivity(intent)
        }
        make_card!!.setOnClickListener {
            var intent = Intent(this, TimeLine_MakeMemory::class.java)
            this.startActivity(intent)
        }
        why_card!!.setOnClickListener {
            showPopUp("La memoria es necesaria ya que esta se presenta como una alternativa al silencio, una mirada al pasado desde el presente, el reconocimiento de años de violencia dolor y sufrimiento de las comunidades, la memoria se presta para ser la voz de las víctimas de una historia no contada, el restablecimiento de la memoria histórica también significa un acto de resiliencia para la vida y la paz.")

        }
        org_card!!.setOnClickListener {
            var intent = Intent(this, Org_Memory::class.java)
            this.startActivity(intent)
        }
        justify!!.setOnClickListener {
            showPopUp("La memoria histórica es una tarea de todos y todas. \n “La memoria se configura como un dispositivo eficaz para cuestionar el aquí y el ahora e inventar el futuro inmediato” (Sánchez, 2016, página 5).")
        }
    }
    private fun showPopUp( text1: String ){
        myDialog0!!.setContentView(R.layout.popupthreep)
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