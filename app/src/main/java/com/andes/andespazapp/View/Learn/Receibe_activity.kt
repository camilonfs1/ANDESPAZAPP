package com.andes.andespazapp.View.Learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.andes.andespazapp.R
import kotlinx.android.synthetic.main.activity_receibe_activity.*

class Receibe_activity : AppCompatActivity() {
    private var texto : TextView? = null
    private var title : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receibe_activity)
        var roll = intent.getStringExtra("Text")
        var tit = intent.getStringExtra("title")
        title = titletxt
        texto = TextDescription

        texto!!.text =  roll
        title!!.text =  tit


    }
}