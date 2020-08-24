package com.andes.andespazapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Spinner
import android.widget.SpinnerAdapter
import com.andes.andespazapp.R
import com.andes.andespazapp.ViewModel.Adapter.AdapterSpinnerSchool
import kotlinx.android.synthetic.main.activity_main_register.*

class MainRegisterActivity : AppCompatActivity() {

    var spinCourse: Spinner? = null
    var adapterCourse = AdapterSpinnerSchool()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_register)

        spinCourse = spin_school

        spinCourse!!.adapter = adapterCourse.full(this)


    }
}

