package com.andes.andespazapp.View.Learn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import com.andes.andespazapp.R
import kotlinx.android.synthetic.main.activity_learn1.*

class Learn1 : AppCompatActivity() {

    private var btn_y : Button? = null
    private var btn_n : Button? = null
    private var text: TextView? = null
    private var btn_acti: CardView? = null
    private var content: ScrollView? = null

    private var QUIZ : CardView? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn1)

        btn_y = btn_yes
        btn_n = btn_no
        btn_acti = Card_activity_memory
        content = conten_scroll

        QUIZ = Card_qz_memory


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

        QUIZ!!.setOnClickListener {
            var intent = Intent(this, qz::class.java)
            this.startActivity(intent)
        }
    }
}