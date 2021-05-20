package com.andes.andespazapp.Model.Firebase

import com.andes.andespazapp.Model.Learn_Item
import com.andes.andespazapp.R

class Learn_Firebase {
    var item: ArrayList<Learn_Item>? = ArrayList()
    fun readDB(): ArrayList<Learn_Item> {
        item = ArrayList()
        item!!.add(
            Learn_Item("1", "Memoria", "", R.drawable.memoriamain, 100)
        )
        item!!.add(
            Learn_Item("2", "Paz", "", R.drawable.pazmain, 100)
        )
        item!!.add(
            Learn_Item("3", "Reconciliacion", "", R.drawable.reconciliacionmain, 100)
        )
        item!!.add(
            Learn_Item("3", "Genero", "", R.drawable.generomain, 100)
        )
        item!!.add(
            Learn_Item("3", "Diversidad", "", R.drawable.diversidadmain, 100)
        )
        item!!.add(
            Learn_Item("3", "Objetores", "", R.drawable.objetores1, 100)
        )
        return item!!
    }

}