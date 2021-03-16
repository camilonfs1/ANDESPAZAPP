package com.andes.andespazapp.View.Learn.Memory

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.andes.andespazapp.R
import kotlinx.android.synthetic.main.activity_qz.*

class qz : AppCompatActivity() {
    private var btnA: Button? = null
    private var btnB: Button? = null
    private var btnC: Button? = null
    private var btnD: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qz)
        btnA = A
        btnB = B
        btnC = C
        btnD = D


        btnA!!.setOnClickListener {
            Toast.makeText(this, "A", Toast.LENGTH_SHORT).show()
        }
        btnB!!.setOnClickListener {
            Toast.makeText(this, "B", Toast.LENGTH_SHORT).show()
        }
        btnC!!.setOnClickListener {
            Toast.makeText(this, "C", Toast.LENGTH_SHORT).show()
        }
        btnD!!.setOnClickListener {
            Toast.makeText(this, "D", Toast.LENGTH_SHORT).show()
        }
    }
}