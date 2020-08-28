package com.andes.andespazapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.andes.andespazapp.R
import com.andes.andespazapp.ViewModel.Adapter.AdapterSpinnerRegion
import com.andes.andespazapp.ViewModel.Adapter.AdapterSpinnerSchool
import com.andes.andespazapp.ViewModel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_main_register.*
import java.util.EnumSet.range

class MainRegisterActivity : AppCompatActivity() {

    var spinCourse: Spinner? = null
    var spinRegion: Spinner? = null

    var adapterCourse = AdapterSpinnerSchool()
    var adapterRegion = AdapterSpinnerRegion()

    var btn_regis: Button? = null

    var registerView: RegisterViewModel = RegisterViewModel()

    var radiogroup_roll: RadioGroup? = null
    var radiogroup_andes: RadioGroup? = null


    var roll: String? = null
    var andes: Boolean? = null

    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_register)

        radiogroup_roll = radio_grupo_rol
        radiogroup_andes = radio_grup_andes


        btn_regis = btn_register

        spinCourse = spin_school
        spinRegion = spin_region
        spinRegion!!.adapter = adapterRegion.full(this)
        spinCourse!!.adapter = adapterCourse.full(this)

        radiogroup_andes?.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)

            if(radio.text.toString() == "Si"){
                andes = true
            }else{
                andes = false
            }
        }
        radiogroup_roll?.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            roll = radio.text.toString()
        }


        btn_regis!!.setOnClickListener {

            //registerView.writebd()
        }
    }
}

