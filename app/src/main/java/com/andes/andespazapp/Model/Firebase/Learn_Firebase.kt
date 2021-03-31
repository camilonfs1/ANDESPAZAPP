package com.andes.andespazapp.Model.Firebase

import com.andes.andespazapp.Model.Learn_Item

class Learn_Firebase {
    var item: ArrayList<Learn_Item>? = ArrayList()
    fun readDB(): ArrayList<Learn_Item>{
        item = ArrayList()
        item!!.add(
            Learn_Item("1", "Memoria", "", 2131230989,100)
        )
        item!!.add(
            Learn_Item("2", "Paz", "", 2131231022,100)
        )
        item!!.add(
            Learn_Item("3", "Reconciliacion", "", 2131231028,100)
        )
        item!!.add(
            Learn_Item("3", "Genero", "", 2131230911,100)
        )
        item!!.add(
            Learn_Item("3", "Diversidad", "", 2131230875,100)
        )
        return item!!
    }

}