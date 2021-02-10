package com.andes.andespazapp.View

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.andes.andespazapp.Model.User
import com.andes.andespazapp.R
import com.andes.andespazapp.ViewModel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_main_register.*

//------------------------------------->  OK



class MainRegisterActivity : AppCompatActivity() {

    var spinCourse: Spinner? = null
    var spinAge: Spinner? = null

    //icon_1_card
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

    var btn_regis: Button? = null

    var registerView: RegisterViewModel = RegisterViewModel()

    var radiogroup_roll: RadioGroup? = null
    var radiogroup_andes: RadioGroup? = null

    var nameTxt: TextView? = null
    var txt_Email: TextView? = null
    var txt_pass: TextView? = null
    var txt_confirm_pass: TextView? = null
    var txt_id: TextView? = null
    var txtRegion: TextView? = null


    var roll: String? = null
    var andes: Boolean? = null
    var name: String? = null
    var icon: Int = 0

    var card = ArrayList<LinearLayout>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_register)

        radiogroup_roll = radio_grupo_rol
        radiogroup_andes = radio_grup_andes
        nameTxt = txt_name_register
        txt_Email = txt_email_register
        txt_pass = txt_pass_register
        txt_confirm_pass = txt_confirm_pass_register
        txt_id = txt_id_register
        txtRegion = txt_region

        btn_regis = btn_register

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

        icon_11!!.setOnClickListener {
            icon = 1
            icon_selected(icon_11!!)}
        icon_12!!.setOnClickListener{
            icon = 2
            icon_selected(icon_12!!)}
        icon_13!!.setOnClickListener{
            icon = 3
            icon_selected(icon_13!!)}
        icon_14!!.setOnClickListener{
            icon = 4
            icon_selected(icon_14!!)}
        icon_21!!.setOnClickListener{
            icon = 5
            icon_selected(icon_21!!)}
        icon_22!!.setOnClickListener{
            icon = 6
            icon_selected(icon_22!!)}
        icon_23!!.setOnClickListener{
            icon = 7
            icon_selected(icon_23!!)}
        icon_24!!.setOnClickListener{
            icon = 8
            icon_selected(icon_24!!)}
        icon_31!!.setOnClickListener{
            icon = 9
            icon_selected(icon_31!!)}
        icon_32!!.setOnClickListener{
            icon = 10
            icon_selected(icon_32!!)}
        icon_33!!.setOnClickListener{
            icon = 11
            icon_selected(icon_33!!)}
        icon_34!!.setOnClickListener{
            icon = 12
            icon_selected(icon_34!!)}

        spinCourse = spin_school
        spinAge = spin_age_register



        radiogroup_andes?.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            if (radio.text.toString() == "Si") {andes = true
            } else {andes = false}
        }
        radiogroup_roll?.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            roll = radio.text.toString()

        }
        btn_regis!!.setOnClickListener {
            if (roll == null)                                                                            {Toast.makeText(this, "Valida tu Roll", Toast.LENGTH_SHORT).show()
            } else if (andes == null)                                                                    {Toast.makeText(this, "Valida si eres de la ANDES", Toast.LENGTH_SHORT).show()
            } else if (nameTxt!!.text.toString() == "")                                                  {Toast.makeText(this, "Ingresa un nombre", Toast.LENGTH_SHORT).show()
            } else if (txt_id!!.text.toString() == "")                                                   {Toast.makeText(this, "Ingresa un numero de identificacion", Toast.LENGTH_SHORT).show()
            } else if (txtRegion!!.text.toString() == "Region : ")                                       {Toast.makeText(this, "Ingresa una region", Toast.LENGTH_SHORT).show()
            } else if (spinAge!!.getSelectedItem().toString() == "Edad :")                               {Toast.makeText(this, "Ingresa una edad", Toast.LENGTH_SHORT).show()
            } else if (txt_Email!!.text.toString() == "" && valida_email())                              {Toast.makeText(this, "Ingresa un Email", Toast.LENGTH_SHORT).show()
            } else if (txt_pass!!.text.toString() == "")                                                 {Toast.makeText(this, "Ingresa contraseña valida", Toast.LENGTH_SHORT).show()
            } else if (txt_confirm_pass!!.text.toString() != (txt_pass!!.text.toString()))               {Toast.makeText(this, "Ingresa contraseña valida e igual", Toast.LENGTH_SHORT).show()
            } else if (icon == 0)                                                                        {Toast.makeText(this, "Selecciona un icono", Toast.LENGTH_SHORT).show()
            } else {
                var user = User(
                    "1",roll!!,andes!!,
                    nameTxt!!.text.toString(),
                    txt_id!!.text.toString(),
                    txtRegion!!.text.toString(),
                    spinAge!!.getSelectedItem().toString(),
                    txt_Email!!.text.toString(),
                    icon
                )
                registerView.writebd(user, txt_pass!!.text.toString(), this)
                registerView.writelocal(user,this)
            }
        }
    }
    fun icon_selected(cardSelecte: LinearLayout) {
        for (i in card) {
            var cardItem = i
            cardItem.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        cardSelecte.setBackgroundColor(Color.parseColor("#01ff90"))
    }
    fun valida_email(): Boolean {
        return true
    }
}

