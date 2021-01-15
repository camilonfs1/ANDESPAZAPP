package com.andes.andespazapp.View.Complaints

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.andes.andespazapp.DB.DB_Administrator
import com.andes.andespazapp.Model.User
import com.andes.andespazapp.Model.ddhh
import com.andes.andespazapp.R
import kotlinx.android.synthetic.main.activity_d_d_h_h__complaints.*

class DDHH_Complaints : AppCompatActivity() {

    var txtprimero: EditText? = null
    var txtsegundo: EditText? =null
    var txttercero: EditText? = null

    var btnenviar: Button?=null


    var databaseHandler: DB_Administrator?=null


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d_d_h_h__complaints)

        val window: Window = this@DDHH_Complaints.window
        window.statusBarColor = ContextCompat.getColor(this@DDHH_Complaints, R.color.ddhh)

        databaseHandler = DB_Administrator(this)


        txtprimero = primero
        txtsegundo = segundo
        txttercero = tercero

        btnenviar = enviar

        btnenviar!!.setOnClickListener {
            var ddhhh = ddhh(txtprimero!!.text.toString(),txtsegundo!!.text.toString(),txttercero!!.text.toString())

           if(databaseHandler!!.insertData2("uno","dos","tres")){
                Toast.makeText(this, "carga",Toast.LENGTH_LONG).show()
           }
           // databaseHandler!!.insertData2(ddhhh)

            var lista = databaseHandler!!.getprice()

            var i=0
            for(Item :String in lista){
                i++
                System.out.println(Item+" - "+ i)
            }

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