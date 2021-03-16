package com.andes.andespazapp.View.Learn.Memory

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.andes.andespazapp.R
import com.andes.andespazapp.View.Learn.Activity
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn1)

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

        }
        how_card!!.setOnClickListener {

        }
        make_card!!.setOnClickListener {

        }
        why_card!!.setOnClickListener {

        }
        org_card!!.setOnClickListener {

        }
        justify!!.setOnClickListener {

        }
    }

}