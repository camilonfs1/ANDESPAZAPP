package com.andes.andespazapp.Model.Firebase

import com.andes.andespazapp.Model.Learn_Item

class Learn_Firebase {
    var item: ArrayList<Learn_Item>? = ArrayList()
    fun readDB(): ArrayList<Learn_Item>{
        item = ArrayList()
        item!!.add(
            Learn_Item("1", "Memoria", "este es el primero", 2131230892,65)
        )
        item!!.add(
            Learn_Item("2", "Paz", "este es el segundo", 2131230909,30)
        )
        item!!.add(
            Learn_Item("3", "Reconciliacion", "este es el tercero", 2131230911,10)
        )
        item!!.add(
            Learn_Item("3", "Genero", "este es el tercero", 2131230862,15)
        )
        item!!.add(
            Learn_Item("3", "Diversidad", "este es el tercero", 2131230860,5)
        )
        return item!!
    }

}