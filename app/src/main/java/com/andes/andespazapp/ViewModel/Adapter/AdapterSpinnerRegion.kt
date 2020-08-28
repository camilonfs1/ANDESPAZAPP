package com.andes.andespazapp.ViewModel.Adapter

import android.R
import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import com.andes.andespazapp.Model.Firebase.Region_Firebase
import com.andes.andespazapp.Model.Region

class AdapterSpinnerRegion: AdapterView.OnItemSelectedListener  {

    var db : Region_Firebase = Region_Firebase()
    var list_of_items: ArrayList<Region>? = null
    var namesRegion: ArrayList<String> = ArrayList()


    fun full(context: Context): SpinnerAdapter {
        list_of_items = db.readDB()
        list_of_items!!.forEach {
            namesRegion.add(it.name)
        }
        val aa = ArrayAdapter(context, R.layout.simple_spinner_item, namesRegion!!)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        return aa
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}