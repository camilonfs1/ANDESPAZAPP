package com.andes.andespazapp.View.Complaints

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.andes.andespazapp.Model.Firebase.DDHH_firebase
import com.andes.andespazapp.Model.ddhh
import com.andes.andespazapp.R
import kotlinx.android.synthetic.main.activity_d_d_h_h__complaints.*

class DDHH_Complaints : AppCompatActivity() {

     var txt_complaint : EditText? = null
    var type: Spinner? = null
    var btn_: Button? = null
    var firebase = DDHH_firebase()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d_d_h_h__complaints)

        txt_complaint = compalint_txt
        type  = ddhh_type
        btn_ = enviar

        val window: Window = this@DDHH_Complaints.window
        window.statusBarColor = ContextCompat.getColor(this@DDHH_Complaints, R.color.ddhh)

        btn_!!.setOnClickListener {
            var complaint = txt_complaint!!.text.toString()
            var type_complaint = type!!.getSelectedItem().toString()
            var complaint_obj = ddhh(complaint, type_complaint)
            firebase.new_ddhh(complaint_obj)

            clear()

            Toast.makeText(this,"Gracias por compartir esta denuncia con ANDES", Toast.LENGTH_LONG).show()

        }

    }

    fun clear(){
        compalint_txt.text.clear()
    }

}