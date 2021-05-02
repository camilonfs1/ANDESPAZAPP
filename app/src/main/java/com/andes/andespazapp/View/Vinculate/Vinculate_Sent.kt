package com.andes.andespazapp.View.Vinculate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.andes.andespazapp.R
import kotlinx.android.synthetic.main.activity_vinculate__sent.*

class Vinculate_Sent : AppCompatActivity() {
    private var sent:CardView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vinculate__sent)

        var id = intent.getStringExtra("id")

        sent = card_sent

        sent!!.setOnClickListener {
            val intent = Intent(this, Sent_vinculate::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }
    }
}