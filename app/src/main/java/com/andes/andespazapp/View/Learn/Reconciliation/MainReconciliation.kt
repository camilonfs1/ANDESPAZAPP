package com.andes.andespazapp.View.Learn.Reconciliation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.andes.andespazapp.R
import com.andes.andespazapp.View.Learn.Diversity.SchoolDiversity
import com.andes.andespazapp.View.Learn.Gender.March8
import kotlinx.android.synthetic.main.activity_main_reconciliation.*

class MainReconciliation : AppCompatActivity() {

    private var card1: CardView? = null
    private var card2: CardView? = null
    private var card3: CardView? = null
    private var card5: CardView? = null
    private var card7: CardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_reconciliation)

        card1 = familia
        card2 =escolar
        card3 =sociedad
        card5 =resolucion_conflictos
        card7 =actividad

        card1!!.setOnClickListener {
            var intent = Intent(this, FamilyReconciliation::class.java)
            this.startActivity(intent)
        }
        card2!!.setOnClickListener {
            var intent = Intent(this, BullyingSchool::class.java)
            this.startActivity(intent)
        }
        card3!!.setOnClickListener {
            var intent = Intent(this, ColombianReconciliation::class.java)
            this.startActivity(intent)
        }
        card5!!.setOnClickListener {
            var intent = Intent(this, ConflicResolution::class.java)
            this.startActivity(intent)
        }
        card7!!.setOnClickListener {
            var intent = Intent(this, ActivityReconciliation::class.java)
            this.startActivity(intent)
        }
    }
}