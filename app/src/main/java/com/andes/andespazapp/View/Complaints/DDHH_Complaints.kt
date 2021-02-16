package com.andes.andespazapp.View.Complaints

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.andes.andespazapp.Model.Person
import com.andes.andespazapp.Model.ddhh
import com.andes.andespazapp.R
import kotlinx.android.synthetic.main.activity_d_d_h_h__complaints.*

class DDHH_Complaints : AppCompatActivity() {

    var txtprimero: EditText? = null
    var txtsegundo: EditText? =null
    var txttercero: EditText? = null

    var btnenviar: Button?=null


    var user: Person? = null


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d_d_h_h__complaints)

        val window: Window = this@DDHH_Complaints.window
        window.statusBarColor = ContextCompat.getColor(this@DDHH_Complaints, R.color.ddhh)



        txtprimero = primero
        txtsegundo = segundo
        txttercero = tercero

        btnenviar = enviar

        user = Person("estudiante",true,"camilo",123456789,"bogota","15","camilo12@gmail.com",1)

        btnenviar!!.setOnClickListener {
            var ddhhh = ddhh(txtprimero!!.text.toString(),txtsegundo!!.text.toString(),txttercero!!.text.toString())

          /*
            var i=0
            for(Item :Person in lista){
                i++
                System.out.println(Item.name+" - "+ Item.key+" - "+Item.email)
            }*/

                      //Start()

        }



    }
    /*fun Start(){
        var User = User("01", "", true, "camilo", "centro", "10", "once", "camilo@gmail.com", 3)
        var db = DB_Administrator(this)
        db.insertData(User)
        System.out.println("hola")

    }*/
}