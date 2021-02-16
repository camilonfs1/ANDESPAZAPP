package com.andes.andespazapp.View.CRUD

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.andes.andespazapp.Model.Person
import com.andes.andespazapp.R
import com.andes.andespazapp.ViewModel.CRUD.CRUD_StudentViewModel
import kotlinx.android.synthetic.main.activity_crud_user.*
import kotlinx.android.synthetic.main.activity_main_register.*
import kotlinx.android.synthetic.main.activity_main_register.icon_11_card
import kotlinx.android.synthetic.main.activity_main_register.icon_12_card
import kotlinx.android.synthetic.main.activity_main_register.icon_13_card
import kotlinx.android.synthetic.main.activity_main_register.icon_14_card
import kotlinx.android.synthetic.main.activity_main_register.icon_21_card
import kotlinx.android.synthetic.main.activity_main_register.icon_22_card
import kotlinx.android.synthetic.main.activity_main_register.icon_23_card
import kotlinx.android.synthetic.main.activity_main_register.icon_24_card
import kotlinx.android.synthetic.main.activity_main_register.icon_31_card
import kotlinx.android.synthetic.main.activity_main_register.icon_32_card
import kotlinx.android.synthetic.main.activity_main_register.icon_33_card
import kotlinx.android.synthetic.main.activity_main_register.icon_34_card

class CRUD_Individual_User : AppCompatActivity() {

    var icon_11: LinearLayout? = null
    var icon_12: LinearLayout? = null
    var icon_13: LinearLayout? = null
    var icon_14: LinearLayout? = null
    var icon_21: LinearLayout? = null
    var icon_22: LinearLayout? = null
    var icon_23: LinearLayout? = null
    var icon_24: LinearLayout? = null
    var icon_31: LinearLayout? = null
    var icon_32: LinearLayout? = null
    var icon_33: LinearLayout? = null
    var icon_34: LinearLayout? = null

    var card = ArrayList<LinearLayout>()
    var icon: Int = 0

    var txtname: EditText? = null
    var txtid: EditText? = null
    var txtemail: EditText? = null
    var txtpass: EditText? = null
    var txtconfirmpass: EditText? = null

    var btnupdate: Button? = null


    var db = CRUD_StudentViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud_user)

        txtname = txtNameCrud
        txtid = txtidCrud
        txtemail = txtemailCrud
        txtpass = txtpassCrud
        txtconfirmpass = txtconfirmpassCrud

        btnupdate = BtnUpdateCrud


        icon_11 = icon_11_card
        icon_12 = icon_12_card
        icon_13 = icon_13_card
        icon_14 = icon_14_card
        icon_21 = icon_21_card
        icon_22 = icon_22_card
        icon_23 = icon_23_card
        icon_24 = icon_24_card
        icon_31 = icon_31_card
        icon_32 = icon_32_card
        icon_33 = icon_33_card
        icon_34 = icon_34_card

        card.add(icon_11!!)
        card.add(icon_12!!)
        card.add(icon_13!!)
        card.add(icon_14!!)
        card.add(icon_21!!)
        card.add(icon_22!!)
        card.add(icon_23!!)
        card.add(icon_24!!)
        card.add(icon_31!!)
        card.add(icon_32!!)
        card.add(icon_33!!)
        card.add(icon_34!!)

        var id = intent.getStringExtra("id")
        var person = db.readData(id)

        txtname!!.text = Editable.Factory.getInstance().newEditable(person.name)
        txtid!!.text = Editable.Factory.getInstance().newEditable(person.identify.toString())
        txtemail!!.text = Editable.Factory.getInstance().newEditable(person.email)
        icon(person.icon!!.toInt())

        icon_11!!.setOnClickListener {
            icon = 1
            icon_selected(icon_11!!)
        }
        icon_12!!.setOnClickListener {
            icon = 2
            icon_selected(icon_12!!)
        }
        icon_13!!.setOnClickListener {
            icon = 3
            icon_selected(icon_13!!)
        }
        icon_14!!.setOnClickListener {
            icon = 4
            icon_selected(icon_14!!)
        }
        icon_21!!.setOnClickListener {
            icon = 5
            icon_selected(icon_21!!)
        }
        icon_22!!.setOnClickListener {
            icon = 6
            icon_selected(icon_22!!)
        }
        icon_23!!.setOnClickListener {
            icon = 7
            icon_selected(icon_23!!)
        }
        icon_24!!.setOnClickListener {
            icon = 8
            icon_selected(icon_24!!)
        }
        icon_31!!.setOnClickListener {
            icon = 9
            icon_selected(icon_31!!)
        }
        icon_32!!.setOnClickListener {
            icon = 10
            icon_selected(icon_32!!)
        }
        icon_33!!.setOnClickListener {
            icon = 11
            icon_selected(icon_33!!)
        }
        icon_34!!.setOnClickListener {
            icon = 12
            icon_selected(icon_34!!)
        }



        btnupdate!!.setOnClickListener {
            var user2: Person
            if (person.name != txtname!!.text.toString() || person.name != txtid!!.text.toString() || person.email != txtemail!!.text.toString() || person.icon != icon) {
                user2 = Person(
                    person.roll,
                    person.andes_asociate!!,
                    txtname!!.text.toString(),
                    person.identify,
                    person.region.toString(),
                    person.age.toString(),
                    txtemail!!.text.toString(),
                    icon!!
                )
                db.update(user2, this)
            }
            if(person.email != txtemail!!.text.toString() || txtpass!!.text.toString() != "" ){
                if (txtpass!!.text.toString() != ""){
                    if(txtpass!!.text.toString() != txtconfirmpass!!.text.toString()){
                        Toast.makeText(this, "Verifica el password ingresado",Toast.LENGTH_SHORT).show()
                    }else{
                        db.updatelogin(txtemail!!.text.toString(),txtpass!!.text.toString())
                    }
                }else{
                    db.updatelogin(txtemail!!.text.toString(),"")
                }
            }

        }
    }

    fun verificate(pass: Person): Int {
        return 0
    }

    fun icon(cardSelecte: Int) {
        card[cardSelecte].setBackgroundColor(Color.parseColor("#01ff90"))
    }

    fun icon_selected(cardSelecte: LinearLayout) {
        for (i in card) {
            var cardItem = i
            cardItem.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        cardSelecte.setBackgroundColor(Color.parseColor("#01ff90"))
    }
}