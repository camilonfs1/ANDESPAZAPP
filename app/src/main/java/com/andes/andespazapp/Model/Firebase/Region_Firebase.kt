package com.andes.andespazapp.Model.Firebase

import com.andes.andespazapp.Model.Region

class Region_Firebase {

    var item: ArrayList<Region>? = ArrayList()
    fun readDB(): ArrayList<Region>{
        item = ArrayList()
        item!!.add(
            Region("1", "Norte", "1")
        )
        item!!.add(
            Region("2", "Sur", "2")
        )
        item!!.add(
            Region("3", "Este", "3")
        )
        item!!.add(
            Region("4", "Oeste", "4")
        )
        item!!.add(
            Region("5", "Centro", "5")
        )
        return item!!
    }
}