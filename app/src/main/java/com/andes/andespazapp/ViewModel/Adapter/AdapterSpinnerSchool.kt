package com.andes.andespazapp.ViewModel.Adapter

import android.R
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import com.andes.andespazapp.Model.Course
import com.andes.andespazapp.Model.Firebase.Courses_Firebase

class AdapterSpinnerSchool: AdapterView.OnItemSelectedListener {

    var db : Courses_Firebase = Courses_Firebase()
    var list_of_items: ArrayList<Course>? = null
    var namesCurses: ArrayList<String> = ArrayList()


    fun full(context: Context): SpinnerAdapter {
        list_of_items = db.read()
        list_of_items!!.forEach {
            namesCurses.add(it.name)
        }
        val aa = ArrayAdapter(context, R.layout.simple_spinner_item, namesCurses!!)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        return aa
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}